package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao implements iDao{

    private final String SQL_FIND= "SELECT * from employees WHERE 1=1 ";
    private final String SQL_DELETE= "DELETE * from employees WHERE ";
    private final String SQL_INSERT= "INSERT INTO employees (first_name, last_name, email, telephone, password_hash) VALUES (?,?,?,?,?) ";
    private final String SQL_UPDATE= "UPDATE employees SET name = ?, description = ? WHERE employee_id = ? ";


    private iMotorSql motorSql;
    public EmployeeDao()
    {
        motorSql = new MotorSql();
    }

    private Object e;

    @Override
    public int add(Object bean) {
        this.e=bean;
        Integer iRet = -1;

        if(e instanceof Employee){
            Employee employee = (Employee) e;
            String sql = SQL_INSERT;
            try{
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setString(1, employee.getFirstName());
                sentencia.setString(2, employee.getLastName());
                sentencia.setString(3, employee.getEmail());
                sentencia.setString(4, employee.getTelephone());
                sentencia.setString(5, employee.getPasswordHash());

                iRet = sentencia.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                motorSql.disconnect();
            }
        }

        return iRet;
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
                if(employee.getTelephone() != null &&  employee.getTelephone() != ""){
                    sql += " AND telephone ='" + employee.getTelephone() + "'";
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
