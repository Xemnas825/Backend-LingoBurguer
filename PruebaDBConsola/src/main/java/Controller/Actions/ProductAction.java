package Controller.Actions;

import Model.Product;
import Model.ProductDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProductAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        if (action != null) {
            switch (action) {
                case "FIND_ALL":
                    return findAll(request, response);
                case "ADD":
                    return add(request, response);
                case "UPDATE":
                    return update(request, response);
                case "DELETE":
                    return delete(request, response);
            }
        }
        return findAll(request, response);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        ProductDao productDao = new ProductDao();
        ArrayList<Product> products = productDao.findAll(null);
        return Product.toArrayJSon(products);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String availableStr = request.getParameter("available");
        String image = request.getParameter("image");
        String categoryIdStr = request.getParameter("category_id1");

        if (name != null && !name.isEmpty() &&
                description != null && !description.isEmpty() &&
                priceStr != null && !priceStr.isEmpty() &&
                availableStr != null && !availableStr.isEmpty() &&
                categoryIdStr != null && !categoryIdStr.isEmpty()) {

            try {
                double price = Double.parseDouble(priceStr);
                boolean available = Boolean.parseBoolean(availableStr);
                int categoryId = Integer.parseInt(categoryIdStr);

                Product product = new Product(name, description, price, available, image, categoryId);
                ProductDao productDao = new ProductDao();
                int result = productDao.add(product);

                return result > 0 ? "Producto agregado: " + name : "No se pudo agregar el producto";
            } catch (NumberFormatException e) {
                return "Error en el formato numérico del precio o categoría";
            }
        } else {
            return "Faltan datos del producto";
        }
    }

    private String update(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String availableStr = request.getParameter("available");
        String image = request.getParameter("image");
        String categoryIdStr = request.getParameter("category_id1");

        if (idStr != null && !idStr.isEmpty() &&
                name != null && !name.isEmpty() &&
                description != null && !description.isEmpty() &&
                priceStr != null && !priceStr.isEmpty() &&
                availableStr != null && !availableStr.isEmpty() &&
                categoryIdStr != null && !categoryIdStr.isEmpty()) {

            try {
                int id = Integer.parseInt(idStr);
                double price = Double.parseDouble(priceStr);
                boolean available = Boolean.parseBoolean(availableStr);
                int categoryId = Integer.parseInt(categoryIdStr);

                Product product = new Product(id, name, description, price, available, image, categoryId);
                ProductDao productDao = new ProductDao();
                int result = productDao.update(product);

                return result > 0 ? "Producto actualizado: " + name : "No se pudo actualizar el producto";
            } catch (NumberFormatException e) {
                return "Error en el formato numérico";
            }
        } else {
            return "Faltan datos para actualizar el producto";
        }
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                ProductDao productDao = new ProductDao();
                int result = productDao.delete(id);

                return result > 0 ? "Producto eliminado ID: " + id : "No se pudo eliminar el producto";
            } catch (NumberFormatException e) {
                return "ID inválido";
            }
        } else {
            return "ID no proporcionado";
        }
    }
}
