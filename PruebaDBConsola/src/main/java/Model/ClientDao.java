package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClientDao implements iDao{

        private final String SQL_FIND= "SELECT * from clients WHERE 1=1 ";
        private final String SQL_INSERT= "INSERT INTO  clients (first_name, last_name, email, telephone, password_hash) VALUES (?,?,?,?,?)";
        private final String SQL_UPDATE= "UPDATE clients set first_name = ?, last_name = ?, email = ?, telephone = ?, password_hash = ? WHERE client_id = ?  ";


        private iMotorSql motorSql;
        private Object e;

        public ClientDao()
        {
            motorSql = new MotorSql();
        }

        @Override
        public int add(Object bean) {
            this.e = bean;
            Integer iRet = -1;

            if (e instanceof Client) {
                Client client = (Client) e;
                String sql = SQL_INSERT;
                try {
                    motorSql.connect();
                    PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                    sentencia.setString(1, client.getFirstName());
                    sentencia.setString(2, client.getLastName());
                    sentencia.setString(3,client.getEmail());
                    sentencia.setString(4,client.getTelephone());
                    sentencia.setString(5,client.getPasswordHash());
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
            this.e = bean;
            Integer iRet= -1;
            if (e instanceof Client) { // Verificamos que sea un objeto Allergen
                Client client = (Client) e; // Convertimos e a Allergen
                String sql = SQL_UPDATE;

                try {
                    motorSql.connect(); // Conectamos a la BD
                    PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                    sentencia.setString(1, client.getFirstName());
                    sentencia.setString(2, client.getLastName());
                    sentencia.setString(3, client.getEmail());
                    sentencia.setString(4, client.getTelephone());
                    sentencia.setString(5, client.getPasswordHash());
                    sentencia.setInt(6, client.getId());

                    iRet = sentencia.executeUpdate(); // Ejecutamos la actualización
                } catch (SQLException ex) {
                    System.out.println(ex);
                } finally {
                    motorSql.disconnect(); // Cerramos conexión
                }
            }
            return iRet;
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
                if(client.getTelephone() != null &&  client.getTelephone() != ""){
                    sql += " AND telephone ='" + client.getTelephone() + "'";
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

    public int getIdByName(String first_name) {
        int id = -1;
        String sql = "SELECT client_id FROM client WHERE first_name = ?";

        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
            sentencia.setString(1, first_name);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                id = rs.getInt("client_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            motorSql.disconnect();
        }

        return id; // Si no se encuentra, devuelve -1
    }
}


