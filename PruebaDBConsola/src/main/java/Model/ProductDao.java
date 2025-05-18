package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDao implements iDao {

    private final String SQL_FIND = "SELECT * FROM products WHERE 1=1";
    private final String SQL_INSERT = "INSERT INTO products (name, description, price, availability, image_url, category_id1) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE products SET name = ?, description = ?, price = ?, availability = ?, image_url = ?, category_id1 = ? WHERE product_id = ?";
    private final String SQL_DELETE = "DELETE FROM products WHERE product_id = ?";

    private iMotorSql motorSql;

    public ProductDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Product product = (Product) bean;
        int productId = -1;
        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, product.getName());
            sentencia.setString(2, product.getDescription());
            sentencia.setDouble(3, product.getPrice());
            sentencia.setBoolean(4, product.getAvailable());
            sentencia.setString(5, product.getImageURL());
            sentencia.setInt(6, product.getCategory());

            int affectedRows = sentencia.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = sentencia.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ProductDao:add:ERROR: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }
        return productId;
    }

    @Override
    public int update(Object bean) {
        Product product = (Product) bean;
        int result = 0;
        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(SQL_UPDATE);
            sentencia.setString(1, product.getName());
            sentencia.setString(2, product.getDescription());
            sentencia.setDouble(3, product.getPrice());
            sentencia.setBoolean(4, product.getAvailable());
            sentencia.setString(5, product.getImageURL());
            sentencia.setInt(6, product.getCategory());
            sentencia.setInt(7, product.getId());

            result = sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ProductDao:update:ERROR: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }
        return result;
    }

    @Override
    public int delete(Object bean) {
        int result = 0;
        int productId = -1;

        if (bean instanceof Integer) {
            productId = (Integer) bean;
        } else if (bean instanceof Product) {
            productId = ((Product) bean).getId();
        }

        if (productId > 0) {
            try {
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(SQL_DELETE);
                sentencia.setInt(1, productId);
                result = sentencia.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("ProductDao:delete:ERROR: " + ex.getMessage());
            } finally {
                motorSql.disconnect();
            }
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
                    sql += " AND product_id = " + product.getId();
                }
                if (product.getName() != null && !product.getName().isEmpty()) {
                    sql += " AND name = '" + product.getName() + "'";
                }
                if (product.getDescription() != null && !product.getDescription().isEmpty()) {
                    sql += " AND description = '" + product.getDescription() + "'";
                }
                if (product.getCategory() > 0) {
                    sql += " AND category_id1 = " + product.getCategory();
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
                        rs.getInt("category_id1")
                );
                products.add(productBd);
            }
        } catch (SQLException ex) {
            System.out.println("ProductDao:findAll:ERROR: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return products;
    }
}