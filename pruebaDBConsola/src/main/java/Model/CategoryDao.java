package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDao implements iDao{
    private final String SQL_FIND= "SELECT * from categories WHERE 1=1 ";
    private iMotorSql motorSql;

    public CategoryDao() {
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
        ArrayList<Category> categories = new ArrayList<Category>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Category category = (Category) bean;

                if(category.getId() >= 0){
                    sql += " AND category_id ='" + category.getId() + "'";
                }
                if(category.getName() != null && category.getName() != "") {
                    sql += " AND name ='" + category.getName() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Category categoryBd= new Category(
                        rs.getInt("category_id"),
                        rs.getString("name"));
                categories.add(categoryBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return categories;
    }
}
