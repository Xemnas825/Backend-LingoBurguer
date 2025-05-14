package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstablishmentDao implements iDao{

    private final String SQL_FIND= "SELECT * from establishments WHERE 1=1 ";
    private iMotorSql motorSql;
    public EstablishmentDao()
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
        ArrayList<Establishment> establishments = new ArrayList<Establishment>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if(bean !=null) {
                Establishment establishment = (Establishment) bean;

                if(establishment.getId() >= 0){
                    sql += " AND establishment_id ='" + establishment.getId() + "'";
                }
                if(establishment.getName() != null && establishment.getName() != ""){
                    sql += " AND name ='" + establishment.getName() + "'";
                }
                if(establishment.getAddress() != null &&  establishment.getAddress() != ""){
                    sql += " AND address ='" + establishment.getAddress() + "'";
                }
                if(establishment.getTelephone() != null &&  establishment.getTelephone() != ""){
                    sql += " AND telephone ='" + establishment.getTelephone() + "'";
                }
                if(establishment.getOpeningHours() != null &&  establishment.getOpeningHours() != ""){
                    sql += " AND opening_hours ='" + establishment.getOpeningHours() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Establishment establishmentBd= new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getString("opening_hours"));
                establishments.add(establishmentBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return establishments;

    }
}
