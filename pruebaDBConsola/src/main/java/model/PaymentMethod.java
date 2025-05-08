package model;

import java.util.ArrayList;

public class PaymentMethod implements iModel {

    private int m_iId;
    private String m_strName;

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


    public PaymentMethod(int p_iId) {
        setId(p_iId);
    }

    public PaymentMethod(int p_iId, String p_strName) {
        setId(p_iId);
        setName(p_strName);
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "m_iId=" + m_iId +
                ", m_strName='" + m_strName + '\'' +
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
