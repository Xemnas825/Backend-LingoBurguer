package Controller.Actions;

import Model.Client;
import Model.ClientDao;
import Model.Employee;
import Model.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.ArrayList;

public class UserAction implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return null;
    }

    private String checkLogin(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Comprobación en clientes
        ClientDao clientDao = new ClientDao();
        ArrayList<Client> clients = clientDao.findAll(null);

        for (Client c : clients) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getPasswordHash().equals(password)) {
                return "CLIENT";
            }
        }

        /*
        if(request.getParameter("DI") == ""){

        }*/

        // Comprobación en empleados
        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employees = employeeDao.findAll(null);

        for (Employee e : employees) {
            if (e.getEmail().equalsIgnoreCase(email) && e.getPasswordHash().equals(password)) {
                return "EMPLOYEE";
            }
        }

        // Si no se encuentra en ninguna tabla
        return "NOT_FOUND";
    }
}
