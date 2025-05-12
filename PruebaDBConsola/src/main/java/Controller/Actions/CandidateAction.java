package Controller.Actions;


import Model.Candidate;
import Model.CandidateDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CandidateAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        CandidateDao candidateDao = new CandidateDao();
        ArrayList<Candidate> product = candidateDao.findAll(null);
        return Candidate.toArrayJSon(product);
    }


}
