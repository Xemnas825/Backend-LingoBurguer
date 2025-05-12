package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JobOffer implements iModel {


    private int m_iID;
    private String m_strTitle;
    private String m_strDescription;
    private double m_dblMinSalary;
    private double m_dblMaxSalary;
    private boolean m_bStatus;
    private Date m_dPublicationDate;
    private Date m_dEndDate;
    private String m_strExperienceRequired;
    private String m_strEducationRequired;


    public int getID() {
        return m_iID;
    }

    public void setID(int _iID) {
        m_iID = m_iID;
    }

    public String getTitle() {
        return m_strTitle;
    }

    public void setTitle(String _strTitle) {
        m_strTitle = m_strTitle;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String _strDescription) {
        m_strDescription = m_strDescription;
    }

    public double getMinSalary() {
        return m_dblMinSalary;
    }

    public void setMinSalary(double _dblMinSalary) {
        m_dblMinSalary = m_dblMinSalary;
    }

    public double getMaxSalary() {
        return m_dblMaxSalary;
    }

    public void setMaxSalary(double _dblMaxSalary) {
        m_dblMaxSalary = m_dblMaxSalary;
    }

    public boolean isStatus() {
        return m_bStatus;
    }

    public void setStatus(boolean _bStatus) {
        m_bStatus = m_bStatus;
    }

    public Date getPublicationDate() {
        return m_dPublicationDate;
    }

    public void setPublicationDate(Date _dPublicationDate) {
        m_dPublicationDate = m_dPublicationDate;
    }

    public Date getEndDate() {
        return m_dEndDate;
    }

    public void setEndDate(Date _dEndDate) {
        m_dEndDate = m_dEndDate;
    }

    public String getExperienceRequired() {
        return m_strExperienceRequired;
    }

    public void setExperienceRequired(String _strExperienceRequired) {
        m_strExperienceRequired = m_strExperienceRequired;
    }

    public String getEducationRequired() {
        return m_strEducationRequired;
    }

    public void setEducationRequired(String _strEducationRequired) {
        m_strEducationRequired = m_strEducationRequired;
    }

    public JobOffer(int m_iID, String m_strTitle, String m_strDescription) {
        setID(m_iID);
        setTitle(m_strTitle);
        setDescription(m_strDescription);
    }

    public JobOffer(int m_iID, String m_strTitle, String m_strDescription, double m_dblMinSalary, double m_dblMaxSalary, boolean m_bStatus, Date m_strPublicationDate, Date m_strEndDate, String m_strExperienceRequired, String m_strEducationRequired) {
        setID(m_iID);
        setTitle(m_strTitle);
        setDescription(m_strDescription);
        setMinSalary(m_dblMinSalary);
        setMaxSalary(m_dblMaxSalary);
        setStatus(m_bStatus);
        setPublicationDate(m_dPublicationDate);
        setEndDate(m_dEndDate);
        setExperienceRequired(m_strExperienceRequired);
        setEducationRequired(m_strEducationRequired);
    }

    @Override
    public String toString() {
        return "Job_offers{" +
                "m_iId=" + (getID()) +
                ", m_strTitle='" + (getTitle()) + '\'' +
                ", m_strDescription='" + getDescription() + '\'' +
                ", m_dblMinSalary='" + getMinSalary() + '\'' +
                ", m_dblMaxSalary='" + getMaxSalary() + '\'' +
                ", m_bStatus='" + isStatus() + '\'' +
                ", m_dPublicationDate='" + getPublicationDate() + '\'' +
                ", m_dEndDate='" + getEndDate() + '\'' +
                ", m_strExperienceRequired='" + getExperienceRequired() + '\'' +
                ", m_strEducationRequired='" + getEducationRequired() + '\'' +
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

    public static String toArrayJSon(ArrayList<JobOffer> jobOffer) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(jobOffer);

        return resp;
    }
}
