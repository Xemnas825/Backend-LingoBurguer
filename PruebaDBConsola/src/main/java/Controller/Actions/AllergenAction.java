package Controller.Actions;



import Model.Allergen;
import Model.AllergenDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AllergenAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        AllergenDao allergenDao = new AllergenDao();
        ArrayList<Allergen> allergen = allergenDao.findAll(null);
        return Allergen.toArrayJSon(allergen);
    }


}
