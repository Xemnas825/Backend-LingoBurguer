package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao implements iDao {

    private final String SQL_FIND = "SELECT employee_id, first_name, last_name, email, telephone, password_hash, hire_date, salary, job_id1, establishment_id1 FROM employees WHERE 1=1 ";
    private final String SQL_DELETE = "DELETE FROM employees WHERE employee_id = ?";
    private final String SQL_INSERT = "INSERT INTO employees (first_name, last_name, email, telephone, password_hash, hire_date, salary, job_id1, establishment_id1) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, telephone = ?, password_hash = ?,hire_date = ?, salary = ?, job_id1 = ?, establishment_id1 = ? WHERE employee_id = ?";

    private iMotorSql motorSql;

    public EmployeeDao() {
        motorSql = new MotorSql();
    }

    private Object e;

    @Override
    public int add(Object bean) {
        Employee employee = (Employee) bean;
        int employeeId = -1;
        String sql = SQL_INSERT;
        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, employee.getFirstName());
            sentencia.setString(2, employee.getLastName());
            sentencia.setString(3, employee.getEmail());
            sentencia.setString(4, employee.getTelephone());
            sentencia.setString(5, employee.getPasswordHash());
            sentencia.setDate(6, employee.getHireDate());
            sentencia.setDouble(7, employee.getSalary());
            sentencia.setInt(8, employee.getFkJob());
            sentencia.setInt(9, employee.getFkEstablishment());

            int affectedRows = sentencia.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = sentencia.getGeneratedKeys();
                if (generatedKeys.next()) {
                    employeeId = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL en `add()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return employeeId;
    }

    @Override
    public int delete(Object e) {
        this.e = e;
        //Comprobar tipo de objeto (o E o I) para asignarlo al ID del elemento idAllergen
        Integer idEmployee = -1;
        Integer iRet = -1;

        if (e instanceof Integer) {
            idEmployee = (Integer) e;
        } else if (e instanceof Employee) {
            idEmployee = ((Employee) e).getId();
        }

        String sql = SQL_DELETE;

        //si puedo asignar el idEmployee PROCEDO A BORRAR
        if (idEmployee > 0) {
            try {
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setInt(1, idEmployee);
                motorSql.execute(sentencia);
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                motorSql.disconnect();
            }
        }
        return iRet;
    }

    @Override
    public int update(Object bean) {
        this.e = bean;
        Integer iRet = -1;
        if (e instanceof Employee) { // Verificamos que sea un objeto Allergen
            Employee employee = (Employee) e; // Convertimos e a Allergen
            String sql = SQL_UPDATE;
            try {
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setString(1, employee.getFirstName());
                sentencia.setString(2, employee.getLastName());
                sentencia.setString(3, employee.getEmail());
                sentencia.setString(4, employee.getTelephone());
                sentencia.setString(5, employee.getPasswordHash());
                sentencia.setDate(6,employee.getHireDate());
                sentencia.setDouble(7,employee.getSalary());
                sentencia.setInt(8, employee.getFkJob());
                sentencia.setInt(9, employee.getFkEstablishment());
                sentencia.setInt(10, employee.getId());

                iRet = sentencia.executeUpdate(); // Retorna número de filas afectadas
            } catch (SQLException ex) {
                System.out.println("Error SQL en `update()`: " + ex.getMessage());
            } finally {
                motorSql.disconnect();
            }
        }
        return iRet;
    }

    @Override
    public ArrayList findAll(Object bean) {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Employee employee = (Employee) bean;

                if (employee.getId() > 0) {
                    sql += " AND employee_id = " + employee.getId();
                }
                if (employee.getFkJob() > 0) {
                    sql += " AND job_id1 = " + employee.getFkJob();
                }
                if (employee.getFkEstablishment() > 0) {
                    sql += " AND establishment_id1 = " + employee.getFkEstablishment();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Employee employeeBd = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("password_hash"),
                        rs.getDate("hire_date"),
                        rs.getDouble("salary"),
                        rs.getInt("job_id1"),
                        rs.getInt("establishment_id1")
                );

                employees.add(employeeBd);
            }
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL en `findAll()`: " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return employees;
    }

    public int getIdByEmail(String email) {
        int id = -1;
        String sql = "SELECT employee_id FROM employees WHERE email = ?";

        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
            sentencia.setString(1, email);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                id = rs.getInt("employee_id"); // Obtiene el ID si el empleado existe
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return id; // Si no se encuentra, devuelve -1
    }
}

