package Model;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao implements iDao {

    private final String SQL_FIND = "SELECT * FROM orders WHERE 1=1 ";
    private final String SQL_INSERT = "INSERT INTO orders (status, total_price, establishment_id2, client_id1, payment_method_id1) VALUES (?, ?, ?, ?, ?)";
    private iMotorSql motorSql;

    public OrderDao() {
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
            sentencia.setString(1, order.getStatus().name());
            sentencia.setDouble(2, order.getTotalPrice());
            // Claves foráneas (pueden ser nulas)
            setNullableInt(sentencia, 3, order.getFkEstablishment());
            setNullableInt(sentencia, 4, order.getFkClient());
            setNullableInt(sentencia, 5, order.getFkPaymentMethod());

            int affectedRows = sentencia.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = sentencia.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }
            }

            // Insertar detalles si se creó la orden
            if (orderId > 0 && order.getOrderDetails() != null) {
                OrderDetailDao orderDetailDao = new OrderDetailDao();
                for (OrderDetail detail : order.getOrderDetails()) {
                    detail.setFkOrderId(orderId);
                    orderDetailDao.add(detail);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL en `add()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return orderId;
    }

    @Override
    public int delete(Object e) {
        int result = 0;
        Order order = (Order) e;

        try {
            motorSql.connect();

            // Eliminar detalles primero (si aplica)
            OrderDetailDao detailDao = new OrderDetailDao();
            OrderDetail filtro = new OrderDetail(0, 0, "", 0, 0);
            filtro.setFkOrderId(order.getId());
            ArrayList<OrderDetail> detalles = detailDao.findAll(filtro);
            for (OrderDetail detail : detalles) {
                detailDao.delete(detail);
            }

            // Luego eliminar la orden
            String sql = "DELETE FROM orders WHERE order_id = ?";
            PreparedStatement stmt = motorSql.getConnection().prepareStatement(sql);
            stmt.setInt(1, order.getId());

            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error SQL en `delete()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
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
                if (order.getStatus() != null) {
                    sql += " AND status = '" + order.getStatus().name() + "'";
                }
                if (order.getFkClient() > 0) {
                    sql += " AND client_id1 = " + order.getFkClient();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Order orderBd = new Order(
                        rs.getInt("order_id"),
                        Order.Status.valueOf(rs.getString("status")),
                        rs.getDouble("total_price"),
                        rs.getInt("establishment_id2"),
                        rs.getInt("client_id1"),
                        rs.getInt("payment_method_id1"),
                        new ArrayList<OrderDetail>()
                );

                loadOrderDetails(orderBd);
                orders.add(orderBd);
            }
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL en `findAll()`: " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return orders;
    }

    private void loadOrderDetails(Order order) {
        if (order == null || order.getId() <= 0) {
            System.out.println("ERROR: No se puede cargar detalles para una orden inválida");
            return;
        }

        System.out.println("Cargando detalles para Order ID: " + order.getId());

        OrderDetailDao orderDetailDao = new OrderDetailDao();
        OrderDetail filtro = new OrderDetail(0, 0, "", 0, 0);
        filtro.setFkOrderId(order.getId());

        try {
            ArrayList<OrderDetail> detalles = orderDetailDao.findAll(filtro);

            if (detalles != null) {
                order.setOrderDetails(detalles);
                System.out.println("✅ Cargados " + detalles.size() + " detalles para Order ID: " + order.getId());
            } else {
                order.setOrderDetails(new ArrayList<OrderDetail>());
                System.out.println("⚠️ No se encontraron detalles para Order ID: " + order.getId());
            }
        } catch (Exception e) {
            System.out.println("❌ Error al cargar detalles para Order ID " + order.getId() + ": " + e.getMessage());
            order.setOrderDetails(new ArrayList<OrderDetail>());
        }
    }

    private void setNullableInt(PreparedStatement stmt, int index, int value) throws SQLException {
        if (value > 0) {
            stmt.setInt(index, value);
        } else {
            stmt.setNull(index, Types.INTEGER);
        }
    }
}
