package Controller.Actions;

import Model.Client;
import Model.ClientDao;
import Model.Employee;
import Model.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class EmployeeAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        if(action != null){
            switch (action) {

                case "FIND_ALL":
                    return findAll(request, response);
                case "ADD":
                    add(request, response);
                    break;
            }
        }
        return findAll(request, response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> product = employeeDao.findAll(null);
        return Employee.toArrayJSon(product);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password_hash = request.getParameter("password_hash");
        String hire_date_str = request.getParameter("hire_date");
        String salary_str = request.getParameter("salary");


        if (first_name != null && !first_name.isEmpty() &&
                last_name != null && !last_name.isEmpty() &&
                email != null && !email.isEmpty() &&
                password_hash != null && !password_hash.isEmpty() &&
                hire_date_str != null && !hire_date_str.isEmpty() &&
                salary_str != null && !salary_str.isEmpty()) {

            try {
                Date hire_date = Date.valueOf(hire_date_str);
                BigDecimal salary = new BigDecimal(salary_str);

                Employee employee = new Employee(first_name, last_name, email, telephone, password_hash);
                EmployeeDao employeeDao = new EmployeeDao();
                int result = employeeDao.add(employee);

                if (result > 0) {
                    return "added employee : " + email;
                } else {
                    return "No se pudo agregar el empleado";
                }
            } catch (IllegalArgumentException e) {
                return "Fecha o salario en formato incorrecto";
            }
        } else {
            return "Faltan datos";
        }
    }

}
