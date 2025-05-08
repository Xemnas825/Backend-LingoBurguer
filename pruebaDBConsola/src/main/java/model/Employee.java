package model;

import java.util.ArrayList;

public class Employee implements iModel {

    private int m_iId;
    private String m_strFirstName;
    private String m_strLastName;
    private String m_strEmail;
    private String m_strPhoneNumber;
    private String m_strPhoneAdress;
    private String m_strPasswordHash;


    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = m_iId;
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

    public String getPhoneAdress() {
        return m_strPhoneAdress;
    }

    public void setPhoneAdress(String _strPhoneAdress) {
        m_strPhoneAdress = _strPhoneAdress;
    }

    public String getPasswordHash() {
        return m_strPasswordHash;
    }

    public void setPasswordHash(String _strPasswordHash) {
        m_strPasswordHash = _strPasswordHash;
    }

    public Employee(int m_iId, String m_strFirstName, String m_strLastName) {
        this.m_iId = m_iId;
        this.m_strFirstName = m_strFirstName;
        this.m_strLastName = m_strLastName;
    }

    public Employee(int m_iId, String m_strFirstName, String m_strLastName,
                    String m_strEmail, String m_strPhoneNumber, String m_strPhoneAdress, String m_strPasswordHash) {
        this.m_iId = m_iId;
        this.m_strFirstName = m_strFirstName;
        this.m_strLastName = m_strLastName;
        this.m_strEmail = m_strEmail;
        this.m_strPhoneNumber = m_strPhoneNumber;
        this.m_strPhoneAdress = m_strPhoneAdress;
        this.m_strPasswordHash = m_strPasswordHash;
    }

    @Override
    public String toString() {
        return "Category{" +
                "m_iId=" + getId() +
                ", m_strFirstName='" + getFirstName() + '\'' +
                ", m_strLastName='" + getLastName() + '\'' +
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
}
