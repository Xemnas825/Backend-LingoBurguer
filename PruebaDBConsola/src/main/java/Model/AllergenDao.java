package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllergenDao implements iDao{

    private final String SQL_FIND= "SELECT * from allergens WHERE 1=1 ";
    private final String SQL_DELETE= "DELETE * from allergens WHERE ";
    private final String SQL_INSERT= "INSERT INTO allergens (name, description) VALUES (?,?) ";
    private final String SQL_UPDATE= "UPDATE allergens SET name = ?, description = ? WHERE allergen_id = ? ";


    private iMotorSql motorSql;
    private Object e;

    public AllergenDao()
    {
        motorSql = new MotorSql();

    }

    @Override
    public int add(Object bean) {
        this.e=bean;
        Integer iRet = -1;

        if(e instanceof Allergen){
            Allergen allergen = (Allergen) e;
            String sql = SQL_INSERT;
            try{
                motorSql.connect();
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setString(1, allergen.getName());
                sentencia.setString(2, allergen.getDescription());
                iRet = sentencia.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                motorSql.disconnect();
            }
        }

        return iRet;
    }

    @Override
    public int delete(Object e) {
        this.e = e;
        //Comprobar tipo de objeto (o E o I) para asignarlo al ID del elemento idAllergen
        Integer idAllergen = -1;
        Integer iRet = -1;

        if(e instanceof Integer)
        {
            idAllergen = (Integer)e;
        }
        else if (e instanceof Allergen)
        {
            idAllergen = ((Allergen)e).getId();
        }

        String sql = SQL_DELETE;

        //si puedo asignar el idAllergen PROCEDO A BORRAR
        if(idAllergen>0)
        {
            try{
                motorSql.connect();
                sql += " allergen_id = ?";
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setInt(1, idAllergen);
                //Esto
                motorSql.setPreparedStatement(sentencia);
                motorSql.execute();
                //O esto
                //motorSql.execute(sentencia);
            }
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            finally
            {
                motorSql.disconnect();
        }
        }


        return 0;
    }

    @Override
    public int update(Object bean) {
        this.e = bean;
        Integer iRet= -1;
        if (e instanceof Allergen) { // Verificamos que sea un objeto Allergen
            Allergen allergen = (Allergen) e; // Convertimos e a Allergen
            String sql = SQL_UPDATE;

            try {
                motorSql.connect(); // Conectamos a la BD
                PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
                sentencia.setString(1, allergen.getName());
                sentencia.setString(2, allergen.getDescription());
                sentencia.setInt(3, allergen.getId());

                iRet = sentencia.executeUpdate(); // Ejecutamos la actualización
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                motorSql.disconnect(); // Cerramos conexión
            }
        }
        return iRet;
    }


    @Override
    public ArrayList findAll(Object bean) {

        ArrayList<Allergen> allergens = new ArrayList<Allergen>();
        String sql = SQL_FIND;

        try
        {
            motorSql.connect();
            if(bean !=null) {
                Allergen allergen = (Allergen) bean;

                if(allergen.getId() >= 0){
                    sql += " AND allergen_id ='" + allergen.getId() + "'";
                }
                if(allergen.getName() != null && allergen.getName() != ""){
                    sql += " AND name ='" + allergen.getName() + "'";
                }
                if(allergen.getDescription() != null &&  allergen.getDescription() != ""){
                    sql += " AND description ='" + allergen.getDescription() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while(rs.next()){
                Allergen allergenBd= new Allergen(
                    rs.getInt("allergen_id"),
                    rs.getString("name"),
                    rs.getString("description"));
                allergens.add(allergenBd);
            }
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }

        return allergens;
    }

    public int getIdByName(String name) {
        int id = -1;
        String sql = "SELECT allergen_id FROM allergens WHERE name = ?";

        try {
            motorSql.connect();
            PreparedStatement sentencia = motorSql.getConnection().prepareStatement(sql);
            sentencia.setString(1, name);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                id = rs.getInt("allergen_id"); // Obtiene el ID si el alérgeno existe
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            motorSql.disconnect();
        }

        return id; // Si no se encuentra, devuelve -1
    }


}
