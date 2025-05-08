package model;

import java.util.ArrayList;

public class Establishment implements iModel{

    private int m_iId;
    private String m_strName;
    private String m_strAddress;
    private String m_strTelephone;
    private String m_strOpeningHours;

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

    public Establishment(int _iId, String _strName, String _strAddress) {
        this.m_iId = _iId;
        this.m_strName = _strName;
        this.m_strAddress = _strAddress;
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
}
