package model;

import java.util.ArrayList;

public class Category implements iModel{
    private int m_iId;
    private String m_strName;

    public int getId() {
        return m_iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String _strName) {
        m_strName = _strName;
    }

    public Category(int _iId, String _strName) {
        m_iId = _iId;
        m_strName = _strName;
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
}
