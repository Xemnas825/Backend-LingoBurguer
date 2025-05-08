package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllergenDao implements iDao{

    private final String SQL_FIND= "SELECT * from allergens WHERE 1=1 ";
    private iMotorSql motorSql;
    public AllergenDao()
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

        ArrayList<Allergen> allergens = new ArrayList<Allergen>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Allergen allergen = (Allergen) bean;

                if(allergen.getId() >= 0){
                    sql += " AND allergen_id ='" + allergen.getId() + "'";
                }
                if(allergen.getName() != null && allergen.getName() != ""){
                    sql += " AND name ='" + allergen.getName() + "'";
                }
                if(allergen.getDescription() != null &&  allergen.getDescription() != ""){
                    sql += " AND description ='" + allergen.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Allergen allergenBd= new Allergen(
                    rs.getInt("allergen_id"),
                    rs.getString("name"),
                    rs.getString("description"));
                allergens.add(allergenBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return allergens;


    }
}
