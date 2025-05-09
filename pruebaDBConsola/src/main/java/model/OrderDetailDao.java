package model;

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
                OrderDetail orderDetails = (Order) bean;

                if(orderDetails.getId() >= 0){
                    sql += " AND detail_id ='" + orderDetails.getId() + "'";
                }
                if(orderDetails.getQuantity() >= 0){
                    sql += " AND detail_id ='" + orderDetails.getQuantity() + "'";
                }
                if(orderDetails.getName() != null && orderDetails.getName() != ""){
                    sql += " AND name ='" + orderDetails.getName() + "'";
                }
                if(orderDetails.getDescription() != null &&  orderDetails.getDescription() != ""){
                    sql += " AND description ='" + orderDetails.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                OrderDetail orderDetailBd= new OrderDetail(
                        rs.getInt("detail_id"),
                        rs.getString("name"),
                        rs.getString("description"));
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
