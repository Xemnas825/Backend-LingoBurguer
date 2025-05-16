package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Client implements iModel {

    private int m_iId;
    private String m_strFirstName;
    private String m_strLastName;
    private String m_strEmail;
    private String m_strTelephone;
    private String m_strPasswordHash;


    public void setId(int _iId) {
        m_iId = _iId;
    }

    public int getId() {
        return m_iId;
    }

    public String getFirstName() {
        return m_strFirstName;
    }

    public void setFirstName(String _strFirstName) {
        m_strFirstName = _strFirstName;
    }

    public String getLastName() {
        return m_strLastName;
    }

    public void setLastName(String _strLastName) {
        m_strLastName = _strLastName;
    }

    public String getEmail() {
        return m_strEmail;
    }

    public void setEmail(String _strEmail) {
        m_strEmail = _strEmail;
    }

    public String getTelephone() {
        return m_strTelephone;
    }

    public void setTelephone(String _strTelephone) {
        this.m_strTelephone = _strTelephone;
    }

    public String getPasswordHash() {
        return m_strPasswordHash;
    }

    public void setPasswordHash(String _strPasswordHash) {
        m_strPasswordHash = _strPasswordHash;
    }

    //todo variable de "created at" de formato DATE

    //Preguntar si en el constructor deberiamos declarar un ID siendo que en la base de datos se autoincrementa
    public Client(int p_iId, String p_strFirstName, String p_strLastName) {
        setId(p_iId);
        setFirstName(p_strFirstName);
        setLastName(p_strLastName);
    }

    public Client(String p_strFirstName, String p_strLastName,String p_strEmail,String p_strTelephone, String p_strPasswordHash) {
        setFirstName(p_strFirstName);
        setLastName(p_strLastName);
        setEmail(p_strEmail);
        setTelephone(p_strTelephone);
        setPasswordHash(p_strPasswordHash);
    }

    public Client(int p_iId, String p_strFirstName, String p_strLastName,String p_strEmail,String p_strTelephone, String p_strPasswordHash) {
        setId(p_iId);
        setFirstName(p_strFirstName);
        setLastName(p_strLastName);
        setEmail(p_strEmail);
        setTelephone(p_strTelephone);
        setPasswordHash(p_strPasswordHash);
    }

    @Override
    public String toString() {
        return "Client{" +
                "m_iId=" + m_iId +
                ", m_strFirstName='" + m_strFirstName + '\'' +
                ", m_strLastName='" + m_strLastName + '\'' +
                ", m_strEmail='" + m_strEmail + '\'' +
                ", m_strTelephone='" + m_strTelephone + '\'' +
                ", m_strPasswordHash='" + m_strPasswordHash + '\'' +
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

    public static String toArrayJSon(ArrayList<Client> client) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(client);

        return resp;
    }
}
