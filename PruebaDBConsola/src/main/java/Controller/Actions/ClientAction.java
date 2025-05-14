package Controller.Actions;


import Model.Category;
import Model.CategoryDao;
import Model.Client;
import Model.ClientDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClientAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {

       /* switch (action) {

            case "FIND_ALL":
                return findAll(request, response);
                break;
                //Pitos
        } */

        return findAll(request, response);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {

        ClientDao clientDao = new ClientDao();
        ArrayList<Client> product = clientDao.findAll(null);
        return Client.toArrayJSon(product);
    }




}
