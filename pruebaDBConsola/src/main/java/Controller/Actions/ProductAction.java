package Controller.Actions;

import Model.Product;
import Model.ProductsDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ProductAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        return "";
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {

        ProductsDao productDao = new ProductsDao();
        ArrayList<Product> product = productDao.findAll(null);
        return Product.toArrayJSon(product);
    }


}
