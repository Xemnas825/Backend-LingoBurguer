package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDao implements iDao{

    private final String SQL_FIND= "SELECT * from clients WHERE 1=1 ";
    private iMotorSql motorSql;
    public ClientDao()
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
        ArrayList<Client> clients = new ArrayList<Client>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Client client = (Client) bean;

                if(client.getId() >= 0){
                    sql += " AND client_id ='" + client.getId() + "'";
                }
                if(client.getFirstName() != null && client.getFirstName() != ""){
                    sql += " AND first_name ='" + client.getFirstName() + "'";
                }
                if(client.getLastName() != null &&  client.getLastName() != ""){
                    sql += " AND last_name ='" + client.getLastName() + "'";
                }
                if(client.getEmail() != null &&  client.getEmail() != ""){
                    sql += " AND email ='" + client.getEmail() + "'";
                }
                if(client.getPhoneNumber() != null &&  client.getPhoneNumber() != ""){
                    sql += " AND telephone ='" + client.getPhoneNumber() + "'";
                }
                if(client.getPasswordHash() != null &&  client.getPasswordHash() != ""){
                    sql += " AND password_hash ='" + client.getPasswordHash() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Client clientBd= new Client(
                        rs.getInt("client_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("password_hash"));
                clients.add(clientBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return clients;
    }

}
