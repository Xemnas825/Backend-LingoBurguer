package model;

import java.util.ArrayList;

public class OrderDetail implements iModel{
    private int m_iId;
    private int m_iQuantity;
    private double m_dblUnitPrice;
    private String m_strNotes;
    private String m_strDescription;

    public int getId() {
        return m_iId;
    }

    public void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public int getQuantity() {
        return m_iQuantity;
    }

    public void setQuantity(int m_iQuantity) {
        this.m_iQuantity = m_iQuantity;
    }

    public double getUnitPrice() {
        return m_dblUnitPrice;
    }

    public void setUnitPrice(double m_dblUnitPrice) {
        this.m_dblUnitPrice = m_dblUnitPrice;
    }

    public String getNotes() {
        return m_strNotes;
    }

    public void setNotes(String m_strNotes) {
        this.m_strNotes = m_strNotes;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String m_strDescription) {
        this.m_strDescription = m_strDescription;
    }

    public OrderDetail(int p_iId) {
        setId(p_iId);
    }

    public OrderDetail(int p_iId, int p_iQuantity, double p_dblUnitPrice, String p_strNotes, String p_strDescription) {
        setId(p_iId);
        setQuantity(p_iQuantity);
        setUnitPrice(p_dblUnitPrice);
        setNotes(p_strNotes);
        setDescription(p_strDescription);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "m_iId=" + m_iId +
                ", m_iQuantity=" + m_iQuantity +
                ", m_dblUnitPrice=" + m_dblUnitPrice +
                ", m_strNotes='" + m_strNotes + '\'' +
                ", m_strDescription='" + m_strDescription + '\'' +
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
