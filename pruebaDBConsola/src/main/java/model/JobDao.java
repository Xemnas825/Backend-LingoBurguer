package model;

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
                    sql += " AND JOB_ID ='" + job.getId() + "'";
                }
                if (job.getTitle() != null && job.getTitle() != "") {
                    sql += " AND JOB_TITLE ='" + job.getTitle() + "'";
                }
                if (job.getMinSalary() >= 0) {
                    sql += " AND MIN_SALARY ='" + job.getMinSalary() + "'";
                }
                if (job.getMaxSalary() >= 0) {
                    sql += " AND MAX_SALARY ='" + job.getMaxSalary() + "'";
                }
            }
            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Job jobBd= new Job(
                        rs.getInt("JOB_ID"),
                        rs.getString("JOB_TITLE"),
                        rs.getDouble("MIN_SALARY"),
                        rs.getDouble("MAX_SALARY"));
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
