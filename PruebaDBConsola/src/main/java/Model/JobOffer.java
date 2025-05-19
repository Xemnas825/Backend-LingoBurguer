package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

public class JobOffer implements iModel {


    private int m_iID;
    private String m_strTitle;
    private String m_strDescription;
    private double m_dblMinSalary;
    private double m_dblMaxSalary;
    private boolean m_bStatus;
    private Date m_dPublicationDate;
    private Date m_dEndDate;
    private String m_strJournal;
    private String m_strExperienceRequired;
    private String m_strEducationRequired;
    private int m_iEstablishmentId;

    // Getters y setters
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

    public String getJournal() {
        return m_strJournal;
    }

    public void setJournal(String _strJournal) {
        m_strJournal = _strJournal;
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

    public int getEstablishmentId() {
        return m_iEstablishmentId;
    }

    public void setEstablishmentId(int _iEstablishmentId) {
        m_iEstablishmentId = _iEstablishmentId;
    }

    // Constructores
    public JobOffer() {
    }

    public JobOffer(int p_iID, String p_strTitle, String p_strDescription) {
        setID(p_iID);
        setTitle(p_strTitle);
        setDescription(p_strDescription);
    }

    public JobOffer(int p_iID, String p_strTitle, String p_strDescription, double p_dblMinSalary,
                    double p_dblMaxSalary, boolean p_bStatus, Date p_dPublicationDate,
                    Date p_dEndDate, String p_strJournal, String p_strExperienceRequired,
                    String p_strEducationRequired, int p_iEstablishmentId) {

        setID(p_iID);
        setTitle(p_strTitle);
        setDescription(p_strDescription);
        setMinSalary(p_dblMinSalary);
        setMaxSalary(p_dblMaxSalary);
        setStatus(p_bStatus);
        setPublicationDate(p_dPublicationDate);
        setEndDate(p_dEndDate);
        setJournal(p_strJournal);
        setExperienceRequired(p_strExperienceRequired);
        setEducationRequired(p_strEducationRequired);
        setEstablishmentId(p_iEstablishmentId);
    }

    // Métodos JSON
    public static String toArrayJSon(ArrayList<JobOffer> jobOffer) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(jobOffer);
    }

    @Override
    public String fromArrayToJson(ArrayList bean) {
        return toArrayJSon(bean);
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return toArrayJSon(bean);
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "ID=" + getID() +
                ", Title='" + getTitle() + '\'' +
                ", Description='" + getDescription() + '\'' +
                ", MinSalary=" + getMinSalary() +
                ", MaxSalary=" + getMaxSalary() +
                ", Status=" + isStatus() +
                ", PublicationDate=" + getPublicationDate() +
                ", EndDate=" + getEndDate() +
                ", Journal='" + getJournal() + '\'' +
                ", ExperienceRequired='" + getExperienceRequired() + '\'' +
                ", EducationRequired='" + getEducationRequired() + '\'' +
                ", EstablishmentId=" + getEstablishmentId() +
                '}';
    }
}
