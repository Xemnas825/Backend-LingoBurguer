package model;

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
                    sql += " AND CLIENT_ID ='" + client.getId() + "'";
                }
                if(client.getFirstName() != null && client.getFirstName() != ""){
                    sql += " AND FIRST_NAME ='" + client.getFirstName() + "'";
                }
                if(client.getLastName() != null &&  client.getLastName() != ""){
                    sql += " AND LAST_NAME ='" + client.getLastName() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Client clientBd= new Client(
                        rs.getInt("CLIENT_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"));
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
