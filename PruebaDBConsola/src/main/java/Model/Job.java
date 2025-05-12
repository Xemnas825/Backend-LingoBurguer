package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Job implements iModel{

    private int m_iId;
    private String m_strTitle;
    private double m_dblMinSalary;
    private double m_dblMaxSalary;

    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = _iId;
    }

    public String getTitle() {
        return m_strTitle;
    }

    public void setTitle(String _strTitle) {
        m_strTitle = _strTitle;
    }

    public double getMinSalary() {
        return m_dblMinSalary;
    }

    public void setMinSalary(double _dblMinSalary) {
        m_dblMinSalary = _dblMinSalary;
    }

    public double getMaxSalary() {
        return m_dblMaxSalary;
    }

    public void setMaxSalary(double _dblMaxSalary) {
        m_dblMaxSalary = _dblMaxSalary;
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
                "m_iId=" + getId() +
                ", m_strTitle='" + getTitle() + '\'' +
                ", m_dblMinSalary=" + getMinSalary() +
                ", m_dblMaxSalary=" + getMaxSalary() +
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

    public static String toArrayJSon(ArrayList<Job> job) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(job);

        return resp;
    }
}

