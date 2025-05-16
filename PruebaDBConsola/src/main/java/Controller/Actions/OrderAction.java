package Controller.Actions;

import Model.Order;
import Model.OrderDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class OrderAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        OrderDao orderDao = new OrderDao();
        ArrayList<Order> order = orderDao.findAll(null);
        return Order.toArrayJSon(order);
    }

    private String add(HttpServletRequest request) {
        String typeOrderReq = request.getParameter("type_order");
        String statusReq = request.getParameter("status");
        String totalPriceReq = request.getParameter("total_price");
        String fkEstablishmentReq = request.getParameter("fk_establishment");
        String fkEmployeeReq = request.getParameter("fk_employee");
        String fkClientReq = request.getParameter("fk_client");
        String fkPaymentMethodReq = request.getParameter("fk_payment_method");

        if (typeOrderReq != null && !typeOrderReq.isEmpty() &&
                statusReq != null && !statusReq.isEmpty() &&
                totalPriceReq != null && !totalPriceReq.isEmpty() &&
                fkEstablishmentReq != null && !fkEstablishmentReq.isEmpty() &&
                fkEmployeeReq != null && !fkEmployeeReq.isEmpty() &&
                fkClientReq != null && !fkClientReq.isEmpty() &&
                fkPaymentMethodReq != null && !fkPaymentMethodReq.isEmpty()) {

            Order.TypeOrder typeOrder = Order.TypeOrder.valueOf(typeOrderReq);
            Order.Status status = Order.Status.valueOf(statusReq);
            double totalPrice = Double.parseDouble(totalPriceReq);
            int fkEstablishment = Integer.parseInt(fkEstablishmentReq);
            int fkEmployee = Integer.parseInt(fkEmployeeReq);
            int fkClient = Integer.parseInt(fkClientReq);
            int fkPaymentMethod = Integer.parseInt(fkPaymentMethodReq);

            Order order = new Order(new Date(), typeOrder, status, totalPrice);
            order.setTypeOrder(typeOrder);
            order.setStatus(status);
            order.setTotalPrice(totalPrice);
            order.setFkEstablishment(fkEstablishment);
            order.setFkEmployee(fkEmployee);
            order.setFkClient(fkClient);
            order.setFkPaymentMethod(fkPaymentMethod);

            OrderDao orderDao = new OrderDao();
            int result = orderDao.add(order);

            if (result > 0) {
                return "addedOrderID" + result;
            } else {
                return "No se pudo agregar el pedido";
            }
        } else {
            return "Faltan datos";
        }
    }
}
