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
                    add(request, response);
                    break;

                case "UPDATE":
                     update(request, response);
                    break;

                case "DELETE":
                     delete(request, response);
                    break;
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
        String image = request.getParameter("image_url");
        String categoryIdStr = request.getParameter("category_id1");

        if (name != null && description != null && priceStr != null && availableStr != null && categoryIdStr != null) {
            try {
                double price = Double.parseDouble(priceStr);
                boolean available = Boolean.parseBoolean(availableStr);
                int categoryId = Integer.parseInt(categoryIdStr);

                Product product = new Product(name, description, price, available, image, categoryId);
                ProductDao productDao = new ProductDao();
                int result = productDao.add(product);

                return result > 0 ? "Producto agregado: " + name : "No se pudo agregar el producto";
            } catch (NumberFormatException e) {
                System.out.println("Error de formato numérico: " + e.getMessage());
                return "Error en el formato numérico";
            } catch (Exception e) {
                System.out.println("Error general: " + e.getMessage());
                return "Error al procesar la solicitud";
            }
        } else {
            return "Faltan datos del producto";
        }
    }

    private String update(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String availableStr = request.getParameter("available");
        String image = request.getParameter("image_url");
        String categoryIdStr = request.getParameter("category_id1");

        // 🔹 Validación de datos
        if (name != null && !name.isEmpty() &&
                description != null && !description.isEmpty() &&
                priceStr != null && !priceStr.isEmpty() &&
                availableStr != null && !availableStr.isEmpty() &&
                categoryIdStr != null && !categoryIdStr.isEmpty()) {

            ProductDao productDao = new ProductDao();
            int id = productDao.getIdByName(name); // Buscar ID por nombre

            if (id > 0) { // Si encontramos el ID, actualizamos
                try {
                    double price = Double.parseDouble(priceStr);
                    boolean available = Boolean.parseBoolean(availableStr);
                    int categoryId = Integer.parseInt(categoryIdStr);

                    Product product = new Product(id, name, description, price, available, image, categoryId);
                    int result = productDao.update(product);

                    return result > 0 ? "Producto actualizado: " + name : "No se pudo actualizar el producto";

                } catch (NumberFormatException e) {
                    return "Error en formato numérico";
                }
            } else {
                return "Producto no encontrado";
            }
        } else {
            return "Faltan datos";
        }
    }





    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        if (name != null && !name.isEmpty()) {
            ProductDao productDao = new ProductDao();
            int id = productDao.getIdByName(name);

            if (id > 0){
                int result = productDao.delete(id); // delete() devuelve un INT

                if (result > 0) {
                    return "deletedId" + id ;
                } else {
                    return "No se pudo eliminar el empleado";
                }
            } else {
                return "Empleado no encontrado";
            }
        } else {
            return "Email no proporcionado";
        }
    }
}
