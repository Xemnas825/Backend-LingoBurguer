package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobDao implements iDao {

    private final String SQL_FIND = "SELECT * from jobs WHERE 1=1 ";
    private iMotorSql motorSql;

    public JobDao() {
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

        ArrayList<Job> jobs = new ArrayList<Job>();
        String sql = SQL_FIND;
        try {
            motorSql.connect();
            if (bean != null) {
                Job job = (Job) bean;

                if (job.getId() >= 0) {
                    sql += " AND job_id ='" + job.getId() + "'";
                }
                if (job.getTitle() != null && job.getTitle() != "") {
                    sql += " AND job_title ='" + job.getTitle() + "'";
                }
                if (job.getMinSalary() >= 0) {
                    sql += " AND min_salary ='" + job.getMinSalary() + "'";
                }
                if (job.getMaxSalary() >= 0) {
                    sql += " AND max_salary ='" + job.getMaxSalary() + "'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Job jobBd= new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_title"),
                        rs.getDouble("min_salary"),
                        rs.getDouble("max_salary"));
                jobs.add(jobBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return jobs;
    }
}
