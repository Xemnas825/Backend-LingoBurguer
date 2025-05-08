package model;

import java.util.ArrayList;

public class Allergen implements iModel {

    private int m_iId;
    private String m_strName;
    private String m_strDescription;

    public int getId() {
        return m_iId;
    }

    public void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String m_strName) {
        this.m_strName = m_strName;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String m_strDescription) {
        this.m_strDescription = m_strDescription;
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
}
