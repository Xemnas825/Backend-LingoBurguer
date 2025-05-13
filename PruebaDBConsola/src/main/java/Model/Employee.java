package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Employee implements iModel {

    private int m_iId;
    private String m_strFirstName;
    private String m_strLastName;
    private String m_strEmail;
    private String m_strPhoneNumber;
    private String m_strAddress;
    private String m_strPasswordHash;


    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = _iId;
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

    public String getPhoneNumber() {
        return m_strPhoneNumber;
    }

    public void setPhoneNumber(String _strPhoneNumber) {
        m_strPhoneNumber = _strPhoneNumber;
    }

    public String getAddress() {
        return m_strAddress;
    }

    public void setAddress(String _strAddress) {
        m_strAddress = _strAddress;
    }

    public String getPasswordHash() {
        return m_strPasswordHash;
    }

    public void setPasswordHash(String _strPasswordHash) {
        m_strPasswordHash = _strPasswordHash;
    }

    public Employee(int p_iId, String p_strFirstName, String p_strLastName) {
        setId(p_iId);
        setFirstName(p_strFirstName);
        setLastName(p_strLastName);
    }

    public Employee(int p_iId, String p_strFirstName, String p_strLastName,
                    String p_strEmail, String p_strPhoneNumber, String p_strAddress, String p_strPasswordHash) {
        setId(p_iId);
        setFirstName(p_strFirstName);
        setLastName(p_strLastName);
        setEmail(p_strEmail);
        setPhoneNumber(p_strPhoneNumber);
        setAddress(p_strAddress);
        setPasswordHash(p_strPasswordHash);
    }

    @Override
    public String toString() {
        return "Category{" +
                "m_iId=" + getId() +
                ", m_strFirstName='" + getFirstName() + '\'' +
                ", m_strLastName='" + getLastName() + '\'' +
                ", m_strEmail='" + getEmail() + '\'' +
                ", m_strPhoneNumber='" + getPhoneNumber() + '\'' +
                ", m_strAddress='" + getAddress() + '\'' +
                ", m_strPasswordHash='" + getPasswordHash() + '\'' +
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

    public static String toArrayJSon(ArrayList<Employee> employee) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(employee);

        return resp;
    }

}
