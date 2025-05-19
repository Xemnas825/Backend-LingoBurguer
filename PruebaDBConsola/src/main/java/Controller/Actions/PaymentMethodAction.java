package Controller.Actions;

import Model.PaymentMethod;
import Model.PaymentMethodDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class PaymentMethodAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        PaymentMethodDao paymentMethodDao = new PaymentMethodDao();
        ArrayList<PaymentMethod> paymentMethod = paymentMethodDao.findAll(null);
        return PaymentMethod.toArrayJSon(paymentMethod);
    }
}
