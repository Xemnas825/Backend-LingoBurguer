package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

public class Employee implements iModel {

    private int m_iId;
    private String m_strFirstName;
    private String m_strLastName;
    private String m_strEmail;
    private String m_strTelephone;
    private String m_strPasswordHash;
    private Date m_hireDate;
    private double m_dblSalary;
    private int m_fkJob;
    private int m_fkEstablishment;

    private Job m_job;
    private Establishment m_establishment;

    // 🔹 Getters y Setters
    public int getId() {
        return m_iId;
    }
    public void setId(int _iId) {
        this.m_iId = _iId;
    }

    public String getFirstName() {
        return m_strFirstName;
    }
    public void setFirstName(String _strFirstName) {
        this.m_strFirstName = _strFirstName;
    }

    public String getLastName() {
        return m_strLastName;
    }
    public void setLastName(String _strLastName) {
        this.m_strLastName = _strLastName;
    }

    public String getEmail() {
        return m_strEmail;
    }
    public void setEmail(String _strEmail) {
        this.m_strEmail = _strEmail;
    }

    public String getTelephone() {
        return m_strTelephone;
    }
    public void setTelephone(String _strTelephone) {
        this.m_strTelephone = _strTelephone;
    }

    public String getPasswordHash() {
        return m_strPasswordHash;
    }
    public void setPasswordHash(String _strPasswordHash) {
        this.m_strPasswordHash = _strPasswordHash;
    }

    public java.sql.Date getHireDate() {
        return (java.sql.Date) m_hireDate;
    }

    public void setHireDate(Date _hireDate) {
        this.m_hireDate = _hireDate;
    }

    public double getSalary() {
        return m_dblSalary;
    }

    public void setSalary(double _dblSalary) {
        this.m_dblSalary = _dblSalary;
    }

    public int getFkJob() {
        return m_fkJob;
    }
    public void setFkJob(int _fkJob) {
        this.m_fkJob = _fkJob;
    }

    public int getFkEstablishment() {
        return m_fkEstablishment;
    }
    public void setFkEstablishment(int _fkEstablishment) {
        this.m_fkEstablishment = _fkEstablishment;
    }

    public Job getJob() {
        return m_job;
    }
    public void setJob(Job _job) {
        this.m_job = _job;
        if (_job != null) {
            this.m_fkJob = _job.getId(); // Actualiza la FK también
        }
    }

    public Establishment getEstablishment() {
        return m_establishment;
    }
    public void setEstablishment(Establishment _establishment) {
        this.m_establishment = _establishment;
        if (_establishment != null) {
            this.m_fkEstablishment = _establishment.getId(); // Actualiza la FK también
        }
    }

    // 🔹 Constructores
    public Employee(String p_firstName, String p_lastName, String p_email, String p_telephone, String p_passwordHash, Date p_hireDate, double p_salary) {
        setFirstName(p_firstName);
        setLastName(p_lastName);
        setEmail(p_email);
        setTelephone(p_telephone);
        setPasswordHash(p_passwordHash);
        setHireDate(p_hireDate);
        setSalary(p_salary);
    }

    public Employee(int p_Id, String p_firstName, String p_lastName, String p_email, String p_telephone, String p_passwordHash, Date p_hireDate, double p_salary,
                    int p_fkJob, int p_fkEstablishment) {
        setId(p_Id);
        setFirstName(p_firstName);
        setLastName(p_lastName);
        setEmail(p_email);
        setTelephone(p_telephone);
        setPasswordHash(p_passwordHash);
        setHireDate(p_hireDate);
        setSalary(p_salary);
        setFkJob(p_fkJob);
        setFkEstablishment(p_fkEstablishment);
    }
    public Employee(String p_firstName, String p_lastName, String p_email, String p_telephone,
                    String p_passwordHash, Date p_hireDate, double p_salary, int p_fkJob, int p_fkEstablishment) {
        setFirstName(p_firstName);
        setLastName(p_lastName);
        setEmail(p_email);
        setTelephone(p_telephone);
        setPasswordHash(p_passwordHash);
        setHireDate(p_hireDate);
        setSalary(p_salary);
        setFkJob(p_fkJob);
        setFkEstablishment(p_fkEstablishment);
    }


    // 🔹 JSON para integración con frontend
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{ ")
                .append("ID=").append(getId())
                .append(", Name=").append(getFirstName()).append(" ").append(getLastName())
                .append(", Email=").append(getEmail())
                .append(", Telephone=").append(getTelephone())
                .append(", PasswordHash=").append(getPasswordHash()) // 🔹 Campo agregado
                .append(", Hire Date=").append(getHireDate()) // 🔹 También estaba faltando
                .append(", Job ID=").append(getFkJob())
                .append(", Establishment ID=").append(getFkEstablishment());

        if (m_job != null) sb.append(", Job=").append(m_job.getTitle());
        if (m_establishment != null) sb.append(", Establishment=").append(m_establishment.getName());

        sb.append(" }");

        return sb.toString();
    }


    @Override
    public String fromArrayToJson(ArrayList bean) {
        return "";
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return "";
    }

    public static String toArrayJSon(ArrayList<Employee> employees) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        return gson.toJson(employees);
    }

}
