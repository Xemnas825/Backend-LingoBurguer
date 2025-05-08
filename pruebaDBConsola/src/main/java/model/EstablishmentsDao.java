package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstablishmentsDao implements iDao{

    private final String SQL_FIND= "SELECT * from establishments WHERE 1=1 ";
    private iMotorSql motorSql;
    public EstablishmentsDao()
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
                    sql += " AND ESTABLISHMENT_ID ='" + establishment.getId() + "'";
                }
                if(establishment.getName() != null && establishment.getName() != ""){
                    sql += " AND NAME ='" + establishment.getName() + "'";
                }
                if(establishment.getAddress() != null &&  establishment.getAddress() != ""){
                    sql += " AND ADDRESS ='" + establishment.getAddress() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Establishment establishmentBd= new Establishment(
                        rs.getInt("ESTABLISHMENT_ID"),
                        rs.getString("NAME"),
                        rs.getString("ADDRESS"));
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
