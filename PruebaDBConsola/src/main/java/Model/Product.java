package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Product implements iModel {

    private int m_iId;
    private String m_strName;
    private String m_strDescription;
    private double m_dblPrice;
    private boolean m_bAvailable;
    private String m_strImageURL;
    private int m_iCategory;



    //TODO Añadir categoryID como foreingKey


    public void setId(int _iId) {
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

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String _strDescription) {
        m_strDescription = _strDescription;
    }

    public double getPrice() {
        return m_dblPrice;
    }

    public void setPrice(double _dblPrice) {
        m_dblPrice = _dblPrice;
    }

    public boolean getAvailable() {
        return m_bAvailable;
    }

    public void setAvailable(boolean _bAvailable) {
        m_bAvailable = _bAvailable;
    }

    public String getImageURL() {
        return m_strImageURL;
    }

    public void setImageURL(String _strImageURL) {
        m_strImageURL = _strImageURL;
    }

    public int getCategory() {
        return m_iCategory;
    }

    public void setCategory(int _iCategory) {
        m_iCategory = _iCategory;
    }

    public Product(int p_iProductId, String p_strName, String p_strDescription) {
        setId(p_iProductId);
        setName(p_strName);
        setDescription(p_strDescription);
    }

    public Product(int p_iProductId, String p_strName, String p_strDescription,
                   double p_dblPrice, boolean p_bAvailable, String p_strImageURL, int p_iCategory)
    {
        setId(p_iProductId);
        setName(p_strName);
        setDescription(p_strDescription);
        setPrice(p_dblPrice);
        setAvailable(p_bAvailable);
        setImageURL(p_strImageURL);
        setCategory(p_iCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "m_iId=" + getId() +
                ", m_strName='" + getName() + '\'' +
                ", m_strDescription='" + getDescription() + '\'' +
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

    public static String toArrayJSon(ArrayList<Product> product) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(product);

        return resp;
    }
}
