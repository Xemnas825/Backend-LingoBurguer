package Controller.Actions;

import Model.Job;
import Model.JobDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class JobAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        JobDao jobDao = new JobDao();
        ArrayList<Job> job = jobDao.findAll(null);
        return Job.toArrayJSon(job);
    }
}
