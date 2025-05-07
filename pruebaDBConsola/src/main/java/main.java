import model.Allergen;
import model.AllergenDao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        AllergenDao aler = new AllergenDao();
        ArrayList<Allergen> allergens = new ArrayList<>();
        allergens = aler.findAll(null); //busca todos los elementos
        System.out.println(allergens.toString());
        allergens = aler.findAll(new Allergen(1,"")); //busca el alergeno where ID=1
        allergens.toString();
    }
}

