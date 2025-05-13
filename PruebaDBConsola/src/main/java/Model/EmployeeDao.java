package Model;

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
                    sql += " AND employee_id ='" + employee.getId() + "'";
                }
                if(employee.getFirstName() != null && employee.getFirstName() != ""){
                    sql += " AND first_name ='" + employee.getFirstName() + "'";
                }
                if(employee.getLastName() != null &&  employee.getLastName() != ""){
                    sql += " AND last_name ='" + employee.getLastName() + "'";
                }
                if(employee.getEmail() != null &&  employee.getEmail() != ""){
                    sql += " AND email ='" + employee.getEmail() + "'";
                }
                if(employee.getPhoneNumber() != null &&  employee.getPhoneNumber() != ""){
                    sql += " AND telephone ='" + employee.getPhoneNumber() + "'";
                }
                if(employee.getAddress() != null &&  employee.getAddress() != ""){
                    sql += " AND address ='" + employee.getAddress() + "'";
                }
                if(employee.getPasswordHash() != null &&  employee.getPasswordHash() != ""){
                    sql += " AND password_hash ='" + employee.getPasswordHash() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Employee employeeBd= new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("address"),
                        rs.getString("password_hash")
                );
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
