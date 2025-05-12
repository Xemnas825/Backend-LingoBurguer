package Controller.Actions;

import Model.Employee;
import Model.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class EmployeeAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> product = employeeDao.findAll(null);
        return Employee.toArrayJSon(product);
    }


}
