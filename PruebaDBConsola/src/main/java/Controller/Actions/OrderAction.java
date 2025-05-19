package Controller.Actions;

import Model.Order;
import Model.OrderDao;
import Model.OrderDetail;
import Model.OrderDetailDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class OrderAction implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        if (action != null) {
            switch (action) {
                case "FIND_ALL":
                    return findAll(request, response);
                case "ADD":
                    add(request, response);
                    break;
            }
        }
        return findAll(request, response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        OrderDao orderDao = new OrderDao();
        ArrayList<Order> order = orderDao.findAll(null);
        return Order.toArrayJSon(order);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String typeOrderReq = request.getParameter("type_order");
        String statusReq = request.getParameter("status");
        String totalPriceReq = request.getParameter("total_price");
        String fkEstablishmentReq = request.getParameter("establishment_id2");
        String fkEmployeeReq = request.getParameter("employee_id1");
        String fkClientReq = request.getParameter("client_id1");
        String fkPaymentMethodReq = request.getParameter("payment_method_id1");

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
            /*int fkEstablishment = Integer.parseInt(fkEstablishmentReq);
            int fkEmployee = Integer.parseInt(fkEmployeeReq);
            int fkClient = Integer.parseInt(fkClientReq);
            int fkPaymentMethod = Integer.parseInt(fkPaymentMethodReq);*/

            Order order = new Order(new Date(), typeOrder, status, totalPrice);

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

