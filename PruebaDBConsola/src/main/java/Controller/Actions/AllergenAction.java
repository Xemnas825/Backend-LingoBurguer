package Controller.Actions;



import Model.Allergen;
import Model.AllergenDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AllergenAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        if(action != null){
            switch (action) {
                case "FIND_ALL":
                    return findAll(request, response);
                case "ADD":
                    add(request, response);
                    break;
                case "DELETE":
                    delete(request,response);
                    break;
                case "UPDATE":
                    update(request,response);
                    break;
            }
        }


        return findAll(request,response);
    }


    private String findAll(HttpServletRequest request,
                           HttpServletResponse response) {
        AllergenDao allergenDao = new AllergenDao();
        ArrayList<Allergen> allergen = allergenDao.findAll(null);
        return Allergen.toArrayJSon(allergen);
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        String allergenName = request.getParameter("name"); // Obtener el nombre desde la petición

        if (allergenName != null && !allergenName.isEmpty()) {
            AllergenDao allergenDao = new AllergenDao();
            int id = allergenDao.getIdByName(allergenName); // Buscar el ID en la BD

            if (id > 0) { // Si encontramos el ID, eliminamos
                int result = allergenDao.delete(id); // delete() devuelve un INT

                if (result > 0) {
                    return "deletedId" + id ;
                } else {
                    return "No se pudo eliminar el alérgeno";
                }
            } else {
                return "Alérgeno no encontrado";
            }
        } else {
            return "Nombre no proporcionado";
        }
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        if (name != null && !name.isEmpty() && description != null && !description.isEmpty()) {
                Allergen allergen = new Allergen(name, description);
                allergen.setName(name);
                allergen.setDescription(description);

                AllergenDao allergenDao = new AllergenDao();
                int result = allergenDao.add(allergen); // Llamamos a add()

                if (result > 0) {
                    return "addedDescription" + description ;
                } else {
                    return "No se pudo agregar el alérgeno";
                }
        } else {
            return "Faltan datos";
        }
    }

    private String update(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        if (name != null && !name.isEmpty() && description != null && !description.isEmpty()) {
            AllergenDao allergenDao = new AllergenDao();
            int id = allergenDao.getIdByName(name); // Buscar ID por nombre

            if (id > 0) { // Si encontramos el ID, actualizamos
                Allergen allergen = new Allergen(id, name, description);
                allergen.setId(id);
                allergen.setName(name);
                allergen.setDescription(description);

                int result = allergenDao.update(allergen);

                if (result > 0) {
                    return "updatedDescription" + description ;
                } else {
                    return "No se pudo actualizar el alérgeno";
                }
            } else {
                return "Alérgeno no encontrado";
            }
        } else {
            return "Faltan datos";
        }
    }


}
