package Model;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Establishment implements iModel{

    private int m_iId;
    private String m_strName;
    private String m_strAddress;
    private String m_strTelephone;
    private String m_strOpeningHours;


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

    public String getAddress() {
        return m_strAddress;
    }

    public void setAddress(String _strAddress) {
        m_strAddress = _strAddress;
    }

    public String getTelephone() {
        return m_strTelephone;
    }

    public void setTelephone(String _strTelephone) {
        m_strTelephone = _strTelephone;
    }

    public String getOpeningHours() {
        return m_strOpeningHours;
    }

    public void setOpeningHours(String _strOpeningHours) {
        m_strOpeningHours = _strOpeningHours;
    }

    public Establishment(int p_iId, String p_strName, String p_strAddress) {
        setId(p_iId);
        setName(p_strName);
        setAddress(p_strAddress);
    }



    @Override
    public String toString() {
        return "Establishment{" +
                "m_iId=" + getId() +
                ", m_strName='" + getName() + '\'' +
                ", m_strAddress='" + getAddress() + '\'' +
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

    public static String toArrayJSon(ArrayList<Establishment> establishment) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(establishment);

        return resp;
    }

}
