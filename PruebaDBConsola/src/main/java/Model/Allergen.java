package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Allergen implements iModel {

    private int m_iId;
    private String m_strName;
    private String m_strDescription;


    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = _iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String _strName) {
        m_strName = _strName;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String _strDescription) {
        m_strDescription = _strDescription;
    }

    public Allergen(int p_iId, String p_strName) {
        setId(p_iId);
        setName(p_strName);
    }

    public Allergen(int p_iId, String p_strName, String p_strDescription) {
        setId(p_iId);
        setName(p_strName);
        setDescription(p_strDescription);
    }

    public Allergen(String m_strName, String m_strDescription) {
        this.m_strName = m_strName;
        this.m_strDescription = m_strDescription;
    }

    @Override
    public String toString() {
        return "Allergen{" +
                "m_iId=" + getId() +
                ", m_strName='" + getName() + '\'' +
                ", m_strDescription='" + getDescription() + '\'' +
                '}';
    }

    @Override
    public String fromArrayToJson(ArrayList bean) {
        return null;
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return null;
    }

    public static String toArrayJSon(ArrayList<Allergen> allergen) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(allergen);

        return resp;
    }
}