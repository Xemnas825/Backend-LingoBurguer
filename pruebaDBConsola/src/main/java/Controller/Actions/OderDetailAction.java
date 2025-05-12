package Controller.Actions;

import Model.OrderDetail;
import Model.OrderDetailDao;
import Model.PaymentMethod;
import Model.PaymentMethodDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class OderDetailAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return "";
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        OrderDetailDao orderDetailDao = new OrderDetailDao();
        ArrayList<OrderDetail> orderDetail = orderDetailDao.findAll(null);
        return OrderDetail.toArrayJSon(orderDetail);
    }
}
