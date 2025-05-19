package Controller.Actions;

import Model.OrderDetail;
import Model.OrderDetailDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class OrderDetailAction implements IAction{
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
        return findAll(request,response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        OrderDetailDao orderDetailDao = new OrderDetailDao();
        ArrayList<OrderDetail> orderDetail = orderDetailDao.findAll(null);
        return OrderDetail.toArrayJSon(orderDetail);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String quantityReq = request.getParameter("quantity");
        String unitPriceReq = request.getParameter("unit_price");
        String notesReq = request.getParameter("notes");
        String fkOrderIdReq = request.getParameter("order_id1");
        String fkProductIdReq = request.getParameter("product_id2");

        // Verificación de datos
        if (quantityReq != null && !quantityReq.isEmpty() &&
                unitPriceReq != null && !unitPriceReq.isEmpty() &&
                fkOrderIdReq != null && !fkOrderIdReq.isEmpty() &&
                fkProductIdReq != null && !fkProductIdReq.isEmpty()) {

            int quantity = Integer.parseInt(quantityReq);
            double unitPrice = Double.parseDouble(unitPriceReq);
            int fkOrderId = Integer.parseInt(fkOrderIdReq);
            int fkProductId = Integer.parseInt(fkProductIdReq);

            OrderDetail orderDetail = new OrderDetail(quantity, unitPrice, notesReq, fkOrderId, fkProductId );
            OrderDetailDao orderDetailDao = new OrderDetailDao();
            int result = orderDetailDao.add(orderDetail);

            if (result > 0) {
                return "addedOrderDetailID" + result;
            } else {
                return "No se pudo agregar el detalle del pedido";
            }
        } else {
            return "Faltan datos";
        }
    }
}
