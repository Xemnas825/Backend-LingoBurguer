package Controller.Actions;


import Model.Category;
import Model.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoryAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        CategoryDao categoryDao = new CategoryDao();
        ArrayList<Category> product = categoryDao.findAll(null);
        return Category.toArrayJSon(product);
    }


}
