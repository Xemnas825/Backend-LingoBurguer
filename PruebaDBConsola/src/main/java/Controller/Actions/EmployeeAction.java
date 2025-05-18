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
                case "DELETE":
                    delete(request,response);
                    break;
                case "UPDATE":
                    update(request,response);
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
        String jobIdStr = request.getParameter("job_id1"); // Nueva clave foránea
        String establishmentIdStr = request.getParameter("establishment_id1"); // Nueva clave foránea


        if (first_name != null && !first_name.isEmpty() &&
                last_name != null && !last_name.isEmpty() &&
                email != null && !email.isEmpty() &&
                password_hash != null && !password_hash.isEmpty() &&
                hire_date_str != null && !hire_date_str.isEmpty() &&
                salary_str != null && !salary_str.isEmpty() &&  jobIdStr != null && !jobIdStr.isEmpty() &&
                establishmentIdStr != null && !establishmentIdStr.isEmpty()) {

            try {
                int jobId = Integer.parseInt(jobIdStr);
                int establishmentId = Integer.parseInt(establishmentIdStr);
                Date hire_date = Date.valueOf(hire_date_str); // 🔹 Convertir la fecha
                double salary = Double.parseDouble(salary_str);

                Employee employee = new Employee(first_name, last_name, email, telephone, password_hash, hire_date, salary, jobId, establishmentId);
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

    private String update(HttpServletRequest request, HttpServletResponse response) {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password_hash = request.getParameter("password_hash");
        String hire_date_str = request.getParameter("hire_date");
        String salary_str = request.getParameter("salary");
        String jobIdStr = request.getParameter("job_id1"); // Nueva clave foránea
        String establishmentIdStr = request.getParameter("establishment_id1"); // Nueva clave foránea

        if (first_name != null && !first_name.isEmpty() &&
                last_name != null && !last_name.isEmpty() &&
                email != null && !email.isEmpty() &&
                password_hash != null && !password_hash.isEmpty() &&
                hire_date_str != null && !hire_date_str.isEmpty() &&
                salary_str != null && !salary_str.isEmpty() && jobIdStr != null && !jobIdStr.isEmpty() &&
                establishmentIdStr != null && !establishmentIdStr.isEmpty()) {

                EmployeeDao employeeDao = new EmployeeDao();
                int id = employeeDao.getIdByEmail(email); // Buscar ID por email

            if (id > 0) { // Si encontramos el ID, actualizamos
                try {
                    Date hire_date = hire_date_str != null && !hire_date_str.isEmpty() ? Date.valueOf(hire_date_str) : null;
                    int jobId = jobIdStr != null && !jobIdStr.isEmpty() ? Integer.parseInt(jobIdStr) : 0;
                    int establishmentId = establishmentIdStr != null && !establishmentIdStr.isEmpty() ? Integer.parseInt(establishmentIdStr) : 0;
                    double salary = Double.parseDouble(salary_str);

                    Employee employee = new Employee(id, first_name, last_name, email, telephone, password_hash, hire_date, salary, jobId, establishmentId);
                    int result = employeeDao.update(employee);
                    return result > 0 ? "updatedEmployee: " + first_name + " " + last_name : "No se pudo actualizar el empleado";

                } catch (IllegalArgumentException e) {
                    return "Error en formato de IDs o fecha de contratación";
                }
            } else {
                return "Empleado no encontrado";
            }
        } else {
            return "Faltan datos";
        }
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email"); // Obtener el email desde la petición

        if (email != null && !email.isEmpty()) {
            EmployeeDao employeeDao = new EmployeeDao();
            int id = employeeDao.getIdByEmail(email); // Buscar el ID en la BD

            if (id > 0) { // Si encontramos el ID, eliminamos
                int result = employeeDao.delete(id); // delete() devuelve un INT

                if (result > 0) {
                    return "deletedId" + id ;
                } else {
                    return "No se pudo eliminar el empleado";
                }
            } else {
                return "Empleado no encontrado";
            }
        } else {
            return "Email no proporcionado";
        }
    }




}
