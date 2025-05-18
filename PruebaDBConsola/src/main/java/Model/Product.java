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
    private int m_fkCategory;



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
        return m_fkCategory;
    }

    public void setCategory(int _iCategory) {
        m_fkCategory = _iCategory;
    }



    // Constructor simple
    public Product(int p_iProductId, String p_strName, String p_strDescription) {
        setId(p_iProductId);
        setName(p_strName);
        setDescription(p_strDescription);
    }

    // Constructor completo con ID (para actualizar)
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

    // Constructor completo sin ID (para añadir)
    public Product(String p_strName, String p_strDescription,
                   double p_dblPrice, boolean p_bAvailable, String p_strImageURL, int p_iCategory)
    {
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
                "m_iId=" + m_iId +
                ", m_strName='" + m_strName + '\'' +
                ", m_strDescription='" + m_strDescription + '\'' +
                ", m_dblPrice=" + m_dblPrice +
                ", m_bAvailable=" + m_bAvailable +
                ", m_strImageURL='" + m_strImageURL + '\'' +
                ", m_fkCategory=" + m_fkCategory +
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
