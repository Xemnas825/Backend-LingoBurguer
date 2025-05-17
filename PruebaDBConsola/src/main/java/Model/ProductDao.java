package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao implements iDao {

    private final String SQL_FIND = "SELECT * FROM products WHERE 1=1";
    private final String SQL_ADD = "INSERT INTO products (name, description, price, availability, image_url, category_id1) VALUES ";
    private final String SQL_UPDATE = "UPDATE products SET ";
    private iMotorSql motorSql;

    public ProductDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Product product = (Product) bean;
        String sql = SQL_ADD + "('" + product.getName() + "','" + product.getDescription() + "',"
                + product.getPrice() + "," + (product.getAvailable() ? 1 : 0) + ",'"
                + product.getImageURL() + "'," + product.getCategory() + ")";
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(sql);
        } catch (Exception ex) {
            System.out.println("ProductDao:add:ERROR: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }
        return resp;
    }

    @Override
    public int update(Object bean) {
        Product product = (Product) bean;
        String sql = SQL_UPDATE
                + "name='" + product.getName() + "', "
                + "description='" + product.getDescription() + "', "
                + "price=" + product.getPrice() + ", "
                + "availability=" + (product.getAvailable() ? 1 : 0) + ", "
                + "image_url='" + product.getImageURL() + "', "
                + "category_id1=" + product.getCategory()
                + " WHERE product_id=" + product.getId();

        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(sql);
        } catch (Exception ex) {
            System.out.println("ProductDao:update:ERROR: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }
        return resp;
    }

    @Override
    public int delete(Object e) {
        int result = 0;
        Product product = (Product) e;
        String sql = "DELETE FROM products WHERE product_id = " + product.getId();

        try {
            motorSql.connect();
            result = motorSql.execute(sql);
        } catch (Exception ex) {
            System.out.println("Error in ProductDao.delete: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
    }

    @Override
    public ArrayList findAll(Object bean) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = SQL_FIND;
        try {
            motorSql.connect();
            if (bean != null) {
                Product product = (Product) bean;

                if (product.getId() >= 0) {
                    sql += " AND product_id ='" + product.getId() + "'";
                }
                if (product.getName() != null && !product.getName().isEmpty()) {
                    sql += " AND name ='" + product.getName() + "'";
                }
                if (product.getDescription() != null && !product.getDescription().isEmpty()) {
                    sql += " AND description ='" + product.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Product productBd = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getBoolean("availability"),
                        rs.getString("image_url"),
                        rs.getInt("category_id1"));
                products.add(productBd);
            }
        } catch (SQLException sqlEx) {
            System.out.println("ProductDao:findAll:ERROR: " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return products;
    }
}
