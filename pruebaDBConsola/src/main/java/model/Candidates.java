package model;

import java.util.ArrayList;
public class Candidates implements iModel {
    private int m_iId;
    private String m_strFirstName;
    private String m_strLastName;
    private String m_strEmail;
    private String m_strTelephone;
    private String m_strCVurl;
    private String m_strLetterPresentation;
    private String m_strApplication_date;
    private String m_strNotes;
    private String m_strAvailability;


    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = m_iId;
    }

    public String getFirstName() {
        return m_strFirstName;
    }

    public void setFirstName(String _strFirstName) {
        m_strFirstName = m_strFirstName;
    }

    public String getLastName() {
        return m_strLastName;
    }

    public void setLastName(String _strLastName) {
        m_strLastName = m_strLastName;
    }

    public String getEmail() {
        return m_strEmail;
    }

    public void setEmail(String _strEmail) {
        m_strEmail = m_strEmail;
    }

    public String getTelephone() {
        return m_strTelephone;
    }

    public void setTelephone(String _strTelephone) {
        m_strTelephone = m_strTelephone;
    }

    public String getCVurl() {
        return m_strCVurl;
    }

    public void setCVurl(String _strCVurl) {
        m_strCVurl = m_strCVurl;
    }

    public String getLetterPresentation() {
        return m_strLetterPresentation;
    }

    public void setLetterPresentation(String _strLetterPresentation) {
        m_strLetterPresentation = m_strLetterPresentation;
    }

    public String getApplication_date() {
        return m_strApplication_date;
    }

    public void setApplication_date(String _strApplication_date) {
        m_strApplication_date = m_strApplication_date;
    }

    public String getNotes() {
        return m_strNotes;
    }

    public void setNotes(String _strNotes) {
        m_strNotes = m_strNotes;
    }

    public String getAvailability() {
        return m_strAvailability;
    }

    public void setAvailability(String _strAvailability) {
        m_strAvailability = m_strAvailability;
    }

    public Candidates(int m_iId, String m_strFirstName, String m_strLastName) {
        this.m_iId = m_iId;
        this.m_strFirstName = m_strFirstName;
        this.m_strLastName = m_strLastName;
    }

    public Candidates(int m_iId, String m_strFirstName, String m_strLastName, String m_strEmail, String m_strTelephone, String m_strCVurl, String m_strLetterPresentation, String m_strApplication_date, String m_strNotes, String m_strAvailability) {
        this.m_iId = m_iId;
        this.m_strFirstName = m_strFirstName;
        this.m_strLastName = m_strLastName;
        this.m_strEmail = m_strEmail;
        this.m_strTelephone = m_strTelephone;
        this.m_strCVurl = m_strCVurl;
        this.m_strLetterPresentation = m_strLetterPresentation;
        this.m_strApplication_date = m_strApplication_date;
        this.m_strNotes = m_strNotes;
        this.m_strAvailability = m_strAvailability;
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "m_iId=" + getId() +
                ", m_strFirstName='" + getFirstName() + '\'' +
                ", m_strLastName='" + getLastName() + '\'' +
                ", m_strEmail='" + getEmail() + '\'' +
                ", m_strTelephone='" + getTelephone() + '\'' +
                ", m_strCVurl='" + getCVurl() + '\'' +
                ", m_strLetterPresentation='" + getLetterPresentation() + '\'' +
                ", m_strApplication_date='" + getApplication_date() + '\'' +
                ", m_strNotes='" + getNotes() + '\'' +
                ", m_strAvailability='" + getAvailability() + '\'' +
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
