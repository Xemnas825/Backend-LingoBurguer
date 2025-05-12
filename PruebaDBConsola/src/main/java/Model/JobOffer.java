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
        m_iID = _iID;
    }

    public String getTitle() {
        return m_strTitle;
    }

    public void setTitle(String _strTitle) {
        m_strTitle = _strTitle;
    }

    public String getDescription() {
        return m_strDescription;
    }

    public void setDescription(String _strDescription) {
        m_strDescription = _strDescription;
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

    public boolean isStatus() {
        return m_bStatus;
    }

    public void setStatus(boolean _bStatus) {
        m_bStatus = _bStatus;
    }

    public Date getPublicationDate() {
        return m_dPublicationDate;
    }

    public void setPublicationDate(Date _dPublicationDate) {
        m_dPublicationDate = _dPublicationDate;
    }

    public Date getEndDate() {
        return m_dEndDate;
    }

    public void setEndDate(Date _dEndDate) {
        m_dEndDate = _dEndDate;
    }

    public String getExperienceRequired() {
        return m_strExperienceRequired;
    }

    public void setExperienceRequired(String _strExperienceRequired) {
        m_strExperienceRequired = _strExperienceRequired;
    }

    public String getEducationRequired() {
        return m_strEducationRequired;
    }

    public void setEducationRequired(String _strEducationRequired) {
        m_strEducationRequired = _strEducationRequired;
    }

    public JobOffer(int p_iID, String p_strTitle, String p_strDescription) {
        setID(p_iID);
        setTitle(p_strTitle);
        setDescription(p_strDescription);
    }

    public JobOffer(int p_iID, String p_strTitle, String p_strDescription, double p_dblMinSalary, double p_dblMaxSalary, boolean p_bStatus, Date p_strPublicationDate, Date p_strEndDate, String p_strExperienceRequired, String p_strEducationRequired) {
        setID(p_iID);
        setTitle(p_strTitle);
        setDescription(p_strDescription);
        setMinSalary(p_dblMinSalary);
        setMaxSalary(p_dblMaxSalary);
        setStatus(p_bStatus);
        setPublicationDate(p_strPublicationDate);
        setEndDate(p_strEndDate);
        setExperienceRequired(p_strExperienceRequired);
        setEducationRequired(p_strEducationRequired);
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
