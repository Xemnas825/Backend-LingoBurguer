package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao implements iDao{

    private final String SQL_FIND= "SELECT * from employees WHERE 1=1 ";
    private iMotorSql motorSql;
    public EmployeeDao()
    {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        return 0;
    }

    @Override
    public int delete(Object e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList findAll(Object bean) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Employee employee = (Employee) bean;

                if(employee.getId() >= 0){
                    sql += " AND EMPLOYEE_ID ='" + employee.getId() + "'";
                }
                if(employee.getFirstName() != null && employee.getFirstName() != ""){
                    sql += " AND FIRST_NAME ='" + employee.getFirstName() + "'";
                }
                if(employee.getLastName() != null &&  employee.getLastName() != ""){
                    sql += " AND LAST_NAME ='" + employee.getLastName() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Employee employeeBd= new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"));
                employees.add(employeeBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return employees;
    }
}
