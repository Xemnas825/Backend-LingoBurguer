package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDetailDao implements iDao {

    private final String SQL_FIND= "SELECT * from order_details WHERE 1=1 ";
    private final String SQL_INSERT = "INSERT INTO order_details (quantity, unit_price, notes, order_id1, product_id2) VALUES (?, ?, ?, ?, ?)";

    private iMotorSql motorSql;
    public OrderDetailDao()
    {
        motorSql = new MotorSql();

    }

    @Override
    public int add(Object bean) {
        int result = -1;
        OrderDetail orderDetail = (OrderDetail) bean;
        String sql = SQL_INSERT;

            try {
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                sentencia.setInt(1, orderDetail.getQuantity());
                sentencia.setDouble(2, orderDetail.getUnitPrice());
                sentencia.setString(3, orderDetail.getNotes());
                sentencia.setInt(4, orderDetail.getFkOrderId());
                sentencia.setInt(5, orderDetail.getFkProductId());

                int affectedRows = sentencia.executeUpdate();
                if (affectedRows > 0) {
                    ResultSet generatedKeys = sentencia.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1);
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error SQL en `add()`: " + ex.getMessage());
            } finally {
                motorSql.disconnect();
            }
        return result;
    }



    @Override
    public int delete(Object e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        int result = 0;
        OrderDetail orderDetail = (OrderDetail) bean;

        String sql = "UPDATE order_details SET quantity = ?, unit_price = ?, notes = ?, order_id1 = ?, product_id2 = ? WHERE detail_id = ?";

        try {
            motorSql.connect();
            PreparedStatement stmt = motorSql.getConnection().prepareStatement(sql);
            stmt.setInt(1, orderDetail.getQuantity());
            stmt.setDouble(2, orderDetail.getUnitPrice());
            stmt.setString(3, orderDetail.getNotes());
            stmt.setInt(4, orderDetail.getFkOrderId());
            stmt.setInt(5, orderDetail.getFkProductId());
            stmt.setInt(6, orderDetail.getId());

            result = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error SQL en `update()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
    }

    @Override
    public ArrayList<OrderDetail> findAll(Object bean) {

        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        String sql= SQL_FIND;

        try
        {
            motorSql.connect();
            if(bean !=null) {
                OrderDetail orderDetail = (OrderDetail) bean;

                if(orderDetail.getId() >= 0){
                    sql += " AND detail_id ='" + orderDetail.getId() + "'";
                }
                if(orderDetail.getQuantity() >= 0){
                    sql += " AND quantity ='" + orderDetail.getQuantity() + "'";
                }
                if(orderDetail.getUnitPrice() >= 0){
                    sql += " AND unit_price ='" + orderDetail.getUnitPrice() + "'";
                }
                if(orderDetail.getNotes() != null &&  orderDetail.getNotes() != ""){
                    sql += " AND notes ='" + orderDetail.getNotes() + "'";
                }
                if (orderDetail.getFkOrderId() > 0) {
                    sql += " AND order_id1 = " + orderDetail.getFkOrderId();
                }
                if (orderDetail.getFkProductId() > 0) {
                    sql += " AND product_id2 = " + orderDetail.getFkProductId();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {


                OrderDetail detailBd = new OrderDetail(
                        rs.getInt("detail_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getString("notes"),
                        rs.getInt("order_id1"),
                        rs.getInt("product_id2"));

                orderDetails.add(detailBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return orderDetails;
    }


    public ArrayList<OrderDetail> findByOrderId(int orderId) {
        ArrayList<OrderDetail> details = new ArrayList<>();
        String sql = "SELECT * FROM order_details WHERE order_id1 = " + orderId;

        try {
            motorSql.connect();
            System.out.println("SQL directo: " + sql);

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                OrderDetail detailBd = new OrderDetail(
                        rs.getInt("detail_id"),
                        rs.getInt("quantity"),
                        rs.getInt("unit_price"),
                        rs.getString("notes"),
                        rs.getInt("order_id1"),
                        rs.getInt("product_id2")
                );
                details.add(detailBd);
            }
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL en findByOrderId(): " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return details;
    }
}
