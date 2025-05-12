package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobOfferDao implements iDao{

    private final String SQL_FIND= "SELECT * from job_offers WHERE 1=1 ";
    private iMotorSql motorSql;
    public JobOfferDao()
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

        ArrayList<JobOffer> jobOffers = new ArrayList<JobOffer>();
        String sql = SQL_FIND;
        try
        {
            motorSql.connect();
            if (bean !=null){
                JobOffer jobOffer = (JobOffer) bean;

                if(jobOffer.getID() >= 0){
                    sql += "AND job_offer_id'" + jobOffer.getID() + "'";
                }
                if (jobOffer.getTitle() !=null && jobOffer.getTitle() !=""){
                    sql += "AND title='" +jobOffer.getTitle() + "'";
                }
                if (jobOffer.getDescription() !=null && jobOffer.getDescription() !=""){
                    sql += "AND description='" +jobOffer.getDescription() +"'";
                }
                if (jobOffer.getMinSalary() >= 0 ){
                    sql += "AND min_salary='" + jobOffer.getMinSalary() + "'";
                }
                if (jobOffer.getMaxSalary() >= 0){
                    sql += "AND max_salary='" + jobOffer.getMaxSalary() +"'";
                }
                if (jobOffer.isStatus()){
                    sql += "AND status='" + jobOffer.isStatus() + "'";
                }
                if (jobOffer.getPublicationDate() !=null ){
                    sql += "AND publication_date='" + jobOffer.getPublicationDate() + "'";
                }
                if (jobOffer.getEndDate() !=null){
                    sql += "AND end_date='" + jobOffer.getEndDate() + "'";
                }
                if (jobOffer.getExperienceRequired() !=null && jobOffer.getExperienceRequired() !=""){
                    sql += "AND experiencie_required='" + jobOffer.getExperienceRequired() + "'";
                }
                if (jobOffer.getEducationRequired() !=null && jobOffer.getEducationRequired() !=""){
                    sql += "AND education_required='" + jobOffer.getEducationRequired() + "'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                JobOffer jobOfferBd= new JobOffer(
                        rs.getInt("job_offer_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("min_salary"),
                        rs.getDouble("max_salary"),
                        rs.getBoolean("status"),
                        rs.getDate("publication_date"),
                        rs.getDate("end_date"),
                        rs.getString("experiencie_required"),
                        rs.getString("education_required"));
                jobOffers.add(jobOfferBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }
        return jobOffers;
    }
}
