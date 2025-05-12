package Controller.Actions;

import Model.Establishment;
import Model.EstablishmentDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class EstablishmentAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        EstablishmentDao establishmentDao = new EstablishmentDao();
        ArrayList<Establishment> product = establishmentDao.findAll(null);
        return Establishment.toArrayJSon(product);
    }


}
