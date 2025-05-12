package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDao implements iDao {

    private final String SQL_FIND= "SELECT * from order_details WHERE 1=1 ";
    private iMotorSql motorSql;
    public OrderDetailDao()
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

        ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
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
                    sql += " AND detail_id ='" + orderDetail.getQuantity() + "'";
                }
                if(orderDetail.getQuantity() >= 0){
                    sql += " AND quantity ='" + orderDetail.getQuantity() + "'";
                }
                if(orderDetail.getDescription() != null &&  orderDetail.getDescription() != ""){
                    sql += " AND description ='" + orderDetail.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                OrderDetail orderDetailBd= new OrderDetail(
                        rs.getInt("detail_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getString("notes"),
                        rs.getInt("order_id1"),
                        rs.getInt("product_id2")
                        );
                orderDetails.add(orderDetailBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return orderDetails;
    }
}
