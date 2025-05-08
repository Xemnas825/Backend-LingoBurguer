package model;

import java.util.ArrayList;

public class Job implements iModel{

    private int m_iId;
    private String m_strTitle;
    private double m_dblMinSalary;
    private double m_dblMaxSalary;

    public int getId() {
        return m_iId;
    }

    public void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public String getTitle() {
        return m_strTitle;
    }

    public void setTitle(String m_strTitle) {
        this.m_strTitle = m_strTitle;
    }

    public double getMinSalary() {
        return m_dblMinSalary;
    }

    public void setMinSalary(double m_dblMinSalary) {
        this.m_dblMinSalary = m_dblMinSalary;
    }

    public double getMaxSalary() {
        return m_dblMaxSalary;
    }

    public void setMaxSalary(double m_dblMaxSalary) {
        this.m_dblMaxSalary = m_dblMaxSalary;
    }


    public Job(int p_iId, String p_strTitle) {
        setId(p_iId);
        setTitle(p_strTitle);
    }

    public Job(int p_iId, String p_strTitle, double p_dblMinSalary, double p_dblMaxSalary) {
        setId(p_iId);
        setTitle(p_strTitle);
        setMinSalary(p_dblMinSalary);
        setMaxSalary(p_dblMaxSalary);
    }

    @Override
    public String toString() {
        return "Job{" +
                "m_iId=" + m_iId +
                ", m_strTitle='" + m_strTitle + '\'' +
                ", m_dblMinSalary=" + m_dblMinSalary +
                ", m_dblMaxSalary=" + m_dblMaxSalary +
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

