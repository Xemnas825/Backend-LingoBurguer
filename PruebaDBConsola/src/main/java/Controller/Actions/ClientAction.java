package Controller.Actions;

import Model.Client;
import Model.ClientDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClientAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {

       if(action != null){
           switch (action) {

               case "FIND_ALL":
                   return findAll(request, response);
               case "ADD_CLIENT":
                   addClient(request, response);
                   break;
           }
       }
        return findAll(request, response);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {

        ClientDao clientDao = new ClientDao();
        ArrayList<Client> product = clientDao.findAll(null);
        return Client.toArrayJSon(product);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) {
        ClientDao clientDao = new ClientDao();
        Client client = new Client(request.getParameter("first_name"),request.getParameter("last_name"),
                request.getParameter("email"),request.getParameter("telephone"),
                request.getParameter("password_hash"));
        clientDao.add(client);
    }

}
