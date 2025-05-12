package Controller.Actions;

import Model.JobOffer;
import Model.JobOfferDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class JobOfferAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }

    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        JobOfferDao jobOfferDao = new JobOfferDao();
        ArrayList<JobOffer> jobOffer = jobOfferDao.findAll(null);
        return JobOffer.toArrayJSon(jobOffer);
    }
}
