package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao implements iDao{

    private final String SQL_FIND = "SELECT * FROM products WHERE 1=1";
    private iMotorSql motorSql;

    public ProductDao()
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
        ArrayList<Product> products = new ArrayList<>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Product product = (Product) bean;

                if(product.getId() >= 0){
                    sql += " AND product_id ='" + product.getId() + "'";
                }
                if(product.getName() != null && product.getName() != ""){
                    sql += " AND name ='" + product.getName() + "'";
                }
                if(product.getDescription() != null &&  product.getDescription() != ""){
                    sql += " AND description ='" + product.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Product productBd = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"));
                products.add(productBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return products;
    }
}
