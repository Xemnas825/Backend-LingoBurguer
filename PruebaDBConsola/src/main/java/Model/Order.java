package Model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Order implements iModel {

    private int m_iId;
    private Date m_DateOrder;
    protected enum TypeOrder {online, physical};
    public enum Status {local, online, take_away};
    private TypeOrder m_eTypeorder;
    private Status m_eStatus;
    private double m_dblTotalPrice;
    private int m_fkEstablishment;
    private int m_fkEmployee;
    private int m_fkClient;
    private int m_fkPaymentMethod;

    private ArrayList<OrderDetail> m_arrayOrderDetails;
    private Establishment m_establishment;
    private Employee m_employee;
    private Client m_client;
    private PaymentMethod m_paymentMethod;

    public int getId() {
        return m_iId;
    }

    public void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public Date getDateOrder() {
        return m_DateOrder;
    }

    public void setDateOrder(Date m_strDateOrder) {
        this.m_DateOrder = m_strDateOrder;
    }

    public TypeOrder getTypeorder() {
        return m_eTypeorder;
    }

    public void setTypeorder(TypeOrder m_eTypeorder) {
        this.m_eTypeorder = m_eTypeorder;
    }

    public Status getStatus() {
        return m_eStatus;
    }

    public void setStatus(Status m_eStatus) {
        this.m_eStatus = m_eStatus;
    }

    public double getTotalPrice() {
        return m_dblTotalPrice;
    }

    public void setTotalPrice(double m_dblTotalPrice) {
        this.m_dblTotalPrice = m_dblTotalPrice;
    }

    public int getFkEstablishment() {
        return m_fkEstablishment;
    }

    public void setFkEstablishment(int m_fkEstablishment) {
        this.m_fkEstablishment = m_fkEstablishment;
    }

    public int getFkEmployee() {
        return m_fkEmployee;
    }

    public void setFkEmployee(int m_fkEmployee) {
        this.m_fkEmployee = m_fkEmployee;
    }

    public int getFkClient() {
        return m_fkClient;
    }

    public void setFkClient(int m_fkClient) {
        this.m_fkClient = m_fkClient;
    }

    public int getFkPaymentMethod() {
        return m_fkPaymentMethod;
    }

    public void setFkPaymentMethod(int m_fkPaymentMethod) {
        this.m_fkPaymentMethod = m_fkPaymentMethod;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return m_arrayOrderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.m_arrayOrderDetails = orderDetails;
    }

    public Establishment getEstablishment() {
        return m_establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.m_establishment = establishment;
        if (establishment != null) {
            this.m_fkEstablishment = establishment.getId(); // Actualiza la FK también
        }
    }

    public Employee getEmployee() {
        return m_employee;
    }

    public void setEmployee(Employee employee) {
        this.m_employee = employee;
        if (employee != null) {
            this.m_fkEmployee = employee.getId();
        }
    }

    public Client getClient() {
        return m_client;
    }

    public void setClient(Client client) {
        this.m_client = client;
        if (client != null) {
            this.m_fkClient = client.getId();
        }
    }

    public PaymentMethod getPaymentMethod() {
        return m_paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.m_paymentMethod = paymentMethod;
        if (paymentMethod != null) {
            this.m_fkPaymentMethod = paymentMethod.getId();
        }
    }


    public Order(int p_iId) {
        setId(p_iId);
        m_arrayOrderDetails = new ArrayList<>();
    }

    public Order(int p_iId, Date p_DateOrder, int p_eTypeorder,
                 int p_eStatus, double p_dblTotalPrice, int p_fkEstablishment,
                 int p_fkEmployee, int p_fkClient, int p_fkPaymentMethod) {
        setId(p_iId);
        setDateOrder(p_DateOrder);
        setTotalPrice(p_dblTotalPrice);
        // todo: setStatus((Status) p_eStatus);
        setFkEstablishment(p_fkEstablishment);
        setFkEmployee(p_fkEmployee);
        setFkClient(p_fkClient);
        setFkPaymentMethod(p_fkPaymentMethod);
        m_arrayOrderDetails = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "m_iId=" + m_iId +
                ", m_strDateOrder='" + m_DateOrder + '\'' +
                ", m_dblTotalPrice=" + m_dblTotalPrice +
                ", m_fkEstablishment=" + m_fkEstablishment +
                ", m_fkEmployee=" + m_fkEmployee +
                ", m_fkClient=" + m_fkClient +
                ", m_fkPaymentMethod=" + m_fkPaymentMethod +
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

    public static String toArrayJSon(ArrayList<Order> order) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(order);

        return resp;
    }
}
