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
               case "ADD":
                   add(request, response);
                   break;
               case "UPDATE":
                    update(request,response);
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

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password_hash = request.getParameter("password_hash");


        if (first_name != null && !first_name.isEmpty() && last_name != null && !last_name.isEmpty() &&
                email != null && !email.isEmpty() && telephone != null && !telephone.isEmpty() &&
                password_hash != null && !password_hash.isEmpty()) {
            Client client = new Client(first_name, last_name,email,telephone,password_hash);
            client.setFirstName(first_name);
            client.setLastName(last_name);
            client.setEmail(email);
            client.setTelephone(telephone);
            client.setPasswordHash(password_hash);

            ClientDao clientDao = new ClientDao();
            int result = clientDao.add(client); // Llamamos a add()

            if (result > 0) {
                return "added client : " + email ;
            } else {
                return "No se pudo agregar el cliente";
            }
        } else {
            return "Faltan datos";
        }
    }

    private String update(HttpServletRequest request, HttpServletResponse response) {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password_hash = request.getParameter("password_hash");


        if (first_name != null && !first_name.isEmpty() && last_name != null && !last_name.isEmpty() && email != null && !email.isEmpty() && telephone != null && !telephone.isEmpty() && password_hash != null && !password_hash.isEmpty()) {
            ClientDao clientDao = new ClientDao();
            int id = clientDao.getIdByName(first_name); // Buscar ID por nombre

            if (id > 0) { // Si encontramos el ID, actualizamos
                Client client = new Client(id, first_name, last_name,email,telephone,password_hash);
                client.setId(id);
                client.setFirstName(first_name);
                client.setLastName(last_name);
                client.setEmail(email);
                client.setTelephone(telephone);
                client.setPasswordHash(password_hash);

                int result = clientDao.update(client);

                if (result > 0) {
                    return "updatedEmail" + email ;
                } else {
                    return "No se pudo actualizar";
                }
            } else {
                return "Cliente no encontrado";
            }
        } else {
            return "Faltan datos";
        }
    }
}
