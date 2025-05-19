package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Category implements iModel{
    private int m_iId;
    private String m_strName;


    public void setId(int _iId){
        m_iId = _iId;
    }

    public int getId() {
        return m_iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String _strName) {
        m_strName = _strName;
    }

    public Category(int p_iId, String p_strName) {
        setId(p_iId);
        setName(p_strName);
    }

    @Override
    public String toString() {
        return "Category{" +
                "m_iId=" + getId() +
                ", m_strName='" + getName() + '\'' +
                '}';
    }

    @Override
    public String fromArrayToJson(ArrayList bean) {
        return "";
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return "";
    }

    public static String toArrayJSon(ArrayList<Category> category) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(category);

        return resp;
    }

}
