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
                if (candidates.getCVurl() !=null && candidates.getCVurl() !=""){
                    sql += "AND cv_url='" +candidates.getCVurl()+"'";
                }
                if (candidates.getLetterPresentation() !=null && candidates.getLetterPresentation() !=""){
                    sql += "AND letter_presentation='" +candidates.getLetterPresentation()+"'";
                }
                if (candidates.getApplication_date() !=null && candidates.getApplication_date() !=""){
                    sql += "AND application_date='" +candidates.getApplication_date() +"'";
                }
                if (candidates.getNotes() !=null && candidates.getNotes() !=""){
                    sql += "AND notes='" +candidates.getNotes() +"'";
                }
                if (candidates.getAvailability() !=null && candidates.getAvailability() !=""){
                    sql += "AND availability='" +candidates.getAvailability() +"'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Candidates candidatesBd= new Candidates(
                        rs.getInt("candidate_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("cv_url"),
                        rs.getString("letter_presentation"),
                        rs.getString("application_date"),
                        rs.getString("notes"),
                        rs.getString("availability"));
                candidate.add(candidatesBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }
        return candidate;
    }
}
