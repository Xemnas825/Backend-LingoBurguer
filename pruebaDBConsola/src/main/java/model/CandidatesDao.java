package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatesDao implements iDao {
    private final String SQL_FIND= "SELECT * from candidates WHERE 1=1 ";
    private iMotorSql motorSql;
    public CandidatesDao()
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
        ArrayList<Candidates> candidate = new ArrayList<Candidates>();
        String sql = SQL_FIND;
        try{

            motorSql.connect();
            if (bean !=null){
                Candidates candidates= (Candidates) bean;

                if (candidates.getId() >=0){
                    sql += "AND candidates_id ='" + candidates.getId() + "'";
                }
                if (candidates.getFirstName() != null && candidates.getFirstName() != ""){
                    sql += " AND first_Name='" + candidates.getFirstName() + "'";
                }
                if (candidates.getLastName() != null && candidates.getLastName() !=""){
                    sql += " AND last_Name='" + candidates.getLastName()+ "'";
                }
                if (candidates.getEmail() !=null && candidates.getEmail() !=""){
                    sql += " AND email='" +candidates.getEmail()+"'";
                }
                if (candidates.getTelephone() !=null && candidates.getTelephone() !=""){
                    sql += "AND telephone='" +candidates.getTelephone()+"'";
                }
            }
        }
    }




}
