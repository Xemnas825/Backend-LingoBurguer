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
        ArrayList<Order> orders = orderDao.findAll(null);

        // Cargar manualmente los detalles para cada orden usando un método directo
        OrderDetailDao detailDao = new OrderDetailDao();

        for (Order order : orders) {
            // Crear un array vacío de detalles si es null
            if (order.getOrderDetails() == null) {
                order.setOrderDetails(new ArrayList<OrderDetail>());
            }

            // Cargar los detalles directamente por ID de orden
            ArrayList<OrderDetail> details = findDetailsByOrderId(order.getId());

            if (details != null && !details.isEmpty()) {
                order.setOrderDetails(details);
            } else {
                System.out.println("No se encontraron detalles para Order ID: " + order.getId());
            }

            System.out.println("Order ID: " + order.getId() + " tiene ahora " +
                    order.getOrderDetails().size() + " detalles");
        }
        return Order.toArrayJSon(orders);
    }
    private ArrayList<OrderDetail> findDetailsByOrderId(int orderId) {
        ArrayList<OrderDetail> details = new ArrayList<>();
        OrderDetailDao detailDao = new OrderDetailDao();

        try {
            // MétodoS 1: Intentar con el métodoS estándar findAll y un filtro
            OrderDetail filter = new OrderDetail(0, 0, "", 0, 0);
            filter.setFkOrderId(orderId);
            details = detailDao.findAll(filter);

            // Si no hay resultados, intenta con el métodoS directo si existe
            if ((details == null || details.isEmpty()) && detailDao.getClass().getMethod("findByOrderId", int.class) != null) {
                details = detailDao.findByOrderId(orderId);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar detalles para Order ID " + orderId + ": " + e.getMessage());
            // No propagar la excepción, simplemente devolver lista vacía
        }

        return details != null ? details : new ArrayList<OrderDetail>();
    }


    private String add(HttpServletRequest request, HttpServletResponse response) {
        String statusReq = request.getParameter("status");
        String totalPriceReq = request.getParameter("total_price");
        String fkEstablishmentReq = request.getParameter("establishment_id2");
        String fkClientReq = request.getParameter("client_id1");
        String fkPaymentMethodReq = request.getParameter("payment_method_id1");

        if (statusReq != null && !statusReq.isEmpty() &&
                totalPriceReq != null && !totalPriceReq.isEmpty() &&
                fkEstablishmentReq != null && !fkEstablishmentReq.isEmpty() &&
                fkClientReq != null && !fkClientReq.isEmpty() &&
                fkPaymentMethodReq != null && !fkPaymentMethodReq.isEmpty()) {

            Order.Status status = Order.Status.valueOf(statusReq);
            double totalPrice = 0.0;
            if (totalPriceReq != null && !totalPriceReq.isEmpty()) {
                totalPrice = Double.parseDouble(totalPriceReq);
            }
            int fkEstablishment = Integer.parseInt(fkEstablishmentReq);
            int fkClient = Integer.parseInt(fkClientReq);
            int fkPaymentMethod = Integer.parseInt(fkPaymentMethodReq);

            Order order = new Order(status, totalPrice, fkEstablishment, fkClient, fkPaymentMethod);

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

