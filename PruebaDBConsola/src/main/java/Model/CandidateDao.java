package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateDao implements iDao {
    private final String SQL_FIND= "SELECT * from candidates WHERE 1=1 ";
    private iMotorSql motorSql;
    public CandidateDao()
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
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        String sql = SQL_FIND;
        try{

            motorSql.connect();
            if (bean !=null){
                Candidate candidate= (Candidate) bean;

                if (candidate.getId() >=0){
                    sql += "AND candidates_id ='" + candidate.getId() + "'";
                }
                if (candidate.getFirstName() != null && candidate.getFirstName() != ""){
                    sql += " AND first_Name='" + candidate.getFirstName() + "'";
                }
                if (candidate.getLastName() != null && candidate.getLastName() !=""){
                    sql += " AND last_Name='" + candidate.getLastName()+ "'";
                }
                if (candidate.getEmail() !=null && candidate.getEmail() !=""){
                    sql += " AND email='" +candidate.getEmail()+"'";
                }
                if (candidate.getTelephone() !=null && candidate.getTelephone() !=""){
                    sql += "AND telephone='" +candidate.getTelephone()+"'";
                }
                if (candidate.getCVurl() !=null && candidate.getCVurl() !=""){
                    sql += "AND cv_url='" +candidate.getCVurl()+"'";
                }
                if (candidate.getLetterPresentation() !=null && candidate.getLetterPresentation() !=""){
                    sql += "AND letter_presentation='" +candidate.getLetterPresentation()+"'";
                }
                if (candidate.getApplication_date() !=null && candidate.getApplication_date() !=""){
                    sql += "AND application_date='" +candidate.getApplication_date() +"'";
                }
                if (candidate.getNotes() !=null && candidate.getNotes() !=""){
                    sql += "AND notes='" +candidate.getNotes() +"'";
                }
                if (candidate.getAvailability() !=null && candidate.getAvailability() !=""){
                    sql += "AND availability='" +candidate.getAvailability() +"'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Candidate candidatesBd= new Candidate(
                        rs.getInt("candidate_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("cv_url"),
                        rs.getString("letter_presentation"),
                        rs.getString("application_date"),
                        rs.getString("notes"),
                        rs.getString("availability"),
                        rs.getInt("job_offer_id1"));
                candidates.add(candidatesBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }
        return candidates;
    }
}
