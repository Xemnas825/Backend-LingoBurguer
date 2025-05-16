package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDao implements iDao {

    private final String SQL_FIND= "SELECT * from orders WHERE 1=1 ";
    private final String SQL_INSERT = "INSERT INTO orders (date_order, type_order, status, total_price, fk_establishment, fk_employee, fk_client, fk_payment_method) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private iMotorSql motorSql;

    public OrderDao()
    {
        motorSql = new MotorSql();

    }


    @Override
    public int add(Object bean) {
        Order order = (Order) bean;
        int orderId = -1;
        String sql = SQL_INSERT;
        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setDate(1, new java.sql.Date(order.getDateOrder().getTime()));
            sentencia.setString(2, order.getTypeOrder().name());
            sentencia.setString(3, order.getStatus().name());
            sentencia.setDouble(4, order.getTotalPrice());
            sentencia.setInt(5, order.getFkEstablishment());
            sentencia.setInt(6, order.getFkEmployee());
            sentencia.setInt(7, order.getFkClient());
            sentencia.setInt(8, order.getFkPaymentMethod());

            int affectedRows = sentencia.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = sentencia.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }
            }

            // Guardar detalles del pedido si la orden se insertó correctamente
            if (orderId > 0) {
                OrderDetailDao orderDetailDao = new OrderDetailDao();
                for (OrderDetail detail : order.getOrderDetails()) {
                    detail.setOrderId(orderId);
                    orderDetailDao.add(detail);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return orderId;
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
    public ArrayList<Order> findAll(Object bean) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Order order = (Order) bean;

                if (order.getId() > 0) {
                    sql += " AND order_id = " + order.getId();
                }
                if (order.getTypeOrder() != null) {
                    sql += " AND type_order = '" + order.getTypeOrder().name() + "'";
                }
                if (order.getStatus() != null) {
                    sql += " AND status = '" + order.getStatus().name() + "'";
                }
                if (order.getFkClient() > 0) {
                    sql += " AND fk_client = " + order.getFkClient();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Order orderBd = new Order(
                        rs.getInt("order_id"),
                        rs.getDate("date_order"),
                        Order.TypeOrder.valueOf(rs.getString("type_order")),
                        Order.Status.valueOf(rs.getString("status")),
                        rs.getDouble("total_price"),
                        rs.getInt("fk_establishment"),
                        rs.getInt("fk_employee"),
                        rs.getInt("fk_client"),
                        rs.getInt("fk_payment_method"),
                        new ArrayList<OrderDetail>() // Los detalles se buscarán en otro método
                );
                orders.add(orderBd);
            }
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL: " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return orders;
    }

}
