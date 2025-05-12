package Controller.Actions;

import Model.Product;
import Model.ProductDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProductAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        ProductDao productDao = new ProductDao();
        ArrayList<Product> product = productDao.findAll(null);
        return Product.toArrayJSon(product);
    }


}
