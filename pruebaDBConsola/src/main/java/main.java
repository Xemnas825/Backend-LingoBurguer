import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        /////////////////TODO DUDAS///////////////////////
        // Como se hacen las tablas intermedias no se hacen
        // Como hacemos las fechas, enum,
        // ¿Esta bien hacer un setId cuando en la BD tiene cada ID para que se autoincremente?

       /*  AllergenDao aler = new AllergenDao();
        ArrayList<Allergen> allergens = new ArrayList<>();
        allergens = aler.findAll(null); //busca todos los elementos
        System.out.println(allergens.toString());
        allergens = aler.findAll(new Allergen(1,"")); //busca el alergeno where ID=1
        allergens.toString(); */

        //Hecho solo con 3 datos de esta tabla todos (expandir)
        /*ProductsDao pro = new ProductsDao();
        ArrayList<Product> products = new ArrayList<>();
        products = pro.findAll(null); //busca todos los elementos
        System.out.println(products.toString());
        products = pro.findAll(new Product(1,"","")); //busca el alergeno where ID=1
        products.toString();*/

        /* CategoryDao cat = new CategoryDao();
        ArrayList<Category> categories = new ArrayList<>();
        categories = cat.findAll(null); //busca todos los elementos
        System.out.println(categories.toString());
        categories = cat.findAll(new Category(1,"")); //busca el alergeno where ID=1
        categories.toString();   */

        /* ClientDao cat = new ClientDao();
        ArrayList<Client> clients = new ArrayList<>();
        clients = cat.findAll(null); //busca todos los elementos
        System.out.println(clients.toString());
        clients = cat.findAll(new Client(1,"","")); //busca el alergeno where ID=1
        clients.toString(); */

        //Ya funca todos revisar
        /* EstablishmentsDao est = new EstablishmentsDao();
        ArrayList<Establishment> establishments = new ArrayList<>();
        establishments = est.findAll(null); //busca todos los elementos
        System.out.println(establishments.toString());
        establishments = est.findAll(new Establishment(1,"","")); //busca el alergeno where ID=1
        establishments = est.findAll(new Establishment(1,"","")); //busca el alergeno where ID=1
        establishments.toString(); */

        /*JobDao est = new JobDao();
        ArrayList<Job> jobs = new ArrayList<>();
        jobs = est.findAll(null); //busca todos los elementos
        System.out.println(jobs.toString());
        jobs = est.findAll(new Job(1,"")); //busca el alergeno where ID=1
        jobs.toString();*/

        /* EmployeeDao est = new EmployeeDao();
        ArrayList<Employee> employees = new ArrayList<>();
        employees = est.findAll(null); //busca todos los elementos
        System.out.println(employees.toString());
        employees = est.findAll(new Employee(1,"","")); //busca el alergeno where ID=1
        employees.toString(); */

        /*PaymentMethodDao est = new PaymentMethodDao();
        ArrayList<PaymentMethod> paymentMethod = new ArrayList<>();
        paymentMethod = est.findAll(null); //busca todos los elementos
        System.out.println(paymentMethod.toString());
        paymentMethod = est.findAll(new PaymentMethod(1,"")); //busca el alergeno where ID=1
        paymentMethod.toString();*/

        OrderDao est = new OrderDao();
        ArrayList<Order> order = new ArrayList<>();
        order = est.findAll(null); //busca todos los elementos
        System.out.println(order.toString());
        order = est.findAll(new Order(1,"",0,1)); //busca el alergeno where ID=1
        order.toString();
    }
}

