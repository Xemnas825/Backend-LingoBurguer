package Controller.Actions;


import Model.Client;
import Model.ClientDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClientAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request, HttpServletResponse response) {

        ClientDao clientDao = new ClientDao();
        ArrayList<Client> product = clientDao.findAll(null);
        return Client.toArrayJSon(product);
    }


}
