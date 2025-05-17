package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobOfferDao implements iDao {

    private final String SQL_FIND = "SELECT * FROM job_offers WHERE 1=1 ";
    private iMotorSql motorSql;

    public JobOfferDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        int result = 0;
        JobOffer jobOffer = (JobOffer) bean;

        String sql = "INSERT INTO job_offers (title, description, min_salary, max_salary, status, " +
                "publication_date, end_date, journal, experience_required, education_required, establishment_id3) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            motorSql.connect();
            PreparedStatement stmt = motorSql.getConnection().prepareStatement(sql);
            stmt.setString(1, jobOffer.getTitle());
            stmt.setString(2, jobOffer.getDescription());
            stmt.setDouble(3, jobOffer.getMinSalary());
            stmt.setDouble(4, jobOffer.getMaxSalary());
            stmt.setBoolean(5, jobOffer.isStatus());
            stmt.setDate(6, new java.sql.Date(jobOffer.getPublicationDate().getTime()));
            stmt.setDate(7, new java.sql.Date(jobOffer.getEndDate().getTime()));
            stmt.setString(8, jobOffer.getJournal());
            stmt.setString(9, jobOffer.getExperienceRequired());
            stmt.setString(10, jobOffer.getEducationRequired());
            stmt.setInt(11, jobOffer.getEstablishmentId());

            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error SQL en `add()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
    }

    @Override
    public int delete(Object e) {
        int result = 0;
        JobOffer jobOffer = (JobOffer) e;
        String sql = "DELETE FROM job_offers WHERE job_offer_id = ?";

        try {
            motorSql.connect();
            PreparedStatement stmt = motorSql.getConnection().prepareStatement(sql);
            stmt.setInt(1, jobOffer.getID());
            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error SQL en `delete()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
    }

    @Override
    public int update(Object bean) {
        int result = 0;
        JobOffer jobOffer = (JobOffer) bean;

        String sql = "UPDATE job_offers SET " +
                "title = ?, description = ?, min_salary = ?, max_salary = ?, status = ?, " +
                "publication_date = ?, end_date = ?, journal = ?, experience_required = ?, " +
                "education_required = ?, establishment_id3 = ? " +
                "WHERE job_offer_id = ?";

        try {
            motorSql.connect();
            PreparedStatement stmt = motorSql.getConnection().prepareStatement(sql);
            stmt.setString(1, jobOffer.getTitle());
            stmt.setString(2, jobOffer.getDescription());
            stmt.setDouble(3, jobOffer.getMinSalary());
            stmt.setDouble(4, jobOffer.getMaxSalary());
            stmt.setBoolean(5, jobOffer.isStatus());
            stmt.setDate(6, new java.sql.Date(jobOffer.getPublicationDate().getTime()));
            stmt.setDate(7, new java.sql.Date(jobOffer.getEndDate().getTime()));
            stmt.setString(8, jobOffer.getJournal());
            stmt.setString(9, jobOffer.getExperienceRequired());
            stmt.setString(10, jobOffer.getEducationRequired());
            stmt.setInt(11, jobOffer.getEstablishmentId());
            stmt.setInt(12, jobOffer.getID());

            result = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error SQL en `update()`: " + ex.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return result;
    }

    @Override
    public ArrayList<JobOffer> findAll(Object bean) {
        ArrayList<JobOffer> jobOffers = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                JobOffer jobOffer = (JobOffer) bean;

                if (jobOffer.getID() >= 0) {
                    sql += " AND job_offer_id = '" + jobOffer.getID() + "'";
                }
                if (jobOffer.getTitle() != null && !jobOffer.getTitle().isEmpty()) {
                    sql += " AND title = '" + jobOffer.getTitle() + "'";
                }
                if (jobOffer.getDescription() != null && !jobOffer.getDescription().isEmpty()) {
                    sql += " AND description = '" + jobOffer.getDescription() + "'";
                }
                if (jobOffer.getMinSalary() >= 0) {
                    sql += " AND min_salary = '" + jobOffer.getMinSalary() + "'";
                }
                if (jobOffer.getMaxSalary() >= 0) {
                    sql += " AND max_salary = '" + jobOffer.getMaxSalary() + "'";
                }
                sql += " AND status = '" + jobOffer.isStatus() + "'";

                if (jobOffer.getPublicationDate() != null) {
                    sql += " AND publication_date = '" + new java.sql.Date(jobOffer.getPublicationDate().getTime()) + "'";
                }
                if (jobOffer.getEndDate() != null) {
                    sql += " AND end_date = '" + new java.sql.Date(jobOffer.getEndDate().getTime()) + "'";
                }
                if (jobOffer.getJournal() != null && !jobOffer.getJournal().isEmpty()) {
                    sql += " AND journal = '" + jobOffer.getJournal() + "'";
                }
                if (jobOffer.getExperienceRequired() != null && !jobOffer.getExperienceRequired().isEmpty()) {
                    sql += " AND experience_required = '" + jobOffer.getExperienceRequired() + "'";
                }
                if (jobOffer.getEducationRequired() != null && !jobOffer.getEducationRequired().isEmpty()) {
                    sql += " AND education_required = '" + jobOffer.getEducationRequired() + "'";
                }
                if (jobOffer.getEstablishmentId() > 0) {
                    sql += " AND establishment_id3 = '" + jobOffer.getEstablishmentId() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                JobOffer jobOfferBd = new JobOffer(
                        rs.getInt("job_offer_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("min_salary"),
                        rs.getDouble("max_salary"),
                        rs.getBoolean("status"),
                        rs.getDate("publication_date"),
                        rs.getDate("end_date"),
                        rs.getString("journal"),
                        rs.getString("experience_required"),
                        rs.getString("education_required"),
                        rs.getInt("establishment_id3")
                );
                jobOffers.add(jobOfferBd);
            }

        } catch (SQLException sqlEx) {
            System.out.println("Error en `findAll()`: " + sqlEx.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return jobOffers;
    }
}
