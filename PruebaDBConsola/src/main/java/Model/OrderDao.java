package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDao implements iDao {

    private final String SQL_FIND= "SELECT * from orders WHERE 1=1 ";
    private final String SQL_ESTABLISHMENTID = "SELECT ord.establishment_id from orders ord INNER JOIN establishments est ON ord.establishment_id2=est.establishment_id ";
    private iMotorSql motorSql;

    public OrderDao()
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

        ArrayList<Order> orders = new ArrayList<Order>();
        String sql = SQL_FIND;
        String sqlEst = SQL_ESTABLISHMENTID;
        try {
            motorSql.connect();
            if (bean != null) {
                Order order = (Order) bean;

                if (order.getId() >= 0) {
                    sql += " AND order_id ='" + order.getId() + "'";
                }
                if (order.getDateOrder() != null) {
                    sql += " AND date_order ='" + order.getDateOrder() + "'";
                }
                if (order.getTotalPrice() >= 0) {
                    sql += " AND total_price ='" + order.getTotalPrice() + "'";
                }
                if (order.getFkEstablishment() >= 0) {
                    sqlEst += " AND establishment_id2='" + order.getFkEstablishment() + "'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Order orderBd = new Order(
                        rs.getInt("order_id"),
                        rs.getDate("date_order"),
                        rs.getInt("type_order"),
                        rs.getInt("status"),
                        rs.getDouble("total_price"),
                        rs.getInt("establishment_id2"),
                        rs.getInt("employee_id1"),
                        rs.getInt("client_id1"),
                        rs.getInt("payment_method_id1")
                );
                orders.add(orderBd);
            }

        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return orders;

    }
}
