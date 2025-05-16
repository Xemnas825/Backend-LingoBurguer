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
    public void setId(int _iId) {
        this.m_iId = _iId;
    }

    public Date getDateOrder() {
        return m_DateOrder;
    }
    public void setDateOrder(Date _strDateOrder) {
        this.m_DateOrder = _strDateOrder;
    }

    public TypeOrder getTypeOrder() {
        return m_eTypeorder;
    }
    public void setTypeOrder(TypeOrder _eTypeorder) {
        this.m_eTypeorder = _eTypeorder;
    }

    public Status getStatus() {
        return m_eStatus;
    }
    public void setStatus(Status _eStatus) {
        this.m_eStatus = _eStatus;
    }

    public double getTotalPrice() {
        return m_dblTotalPrice;
    }
    public void setTotalPrice(double _dblTotalPrice) {
        this.m_dblTotalPrice = _dblTotalPrice;
    }

    public int getFkEstablishment() {
        return m_fkEstablishment;
    }
    public void setFkEstablishment(int _fkEstablishment) {
        this.m_fkEstablishment = _fkEstablishment;
    }

    public int getFkEmployee() {
        return m_fkEmployee;
    }
    public void setFkEmployee(int _fkEmployee) {
        this.m_fkEmployee = _fkEmployee;
    }

    public int getFkClient() {
        return m_fkClient;
    }
    public void setFkClient(int _fkClient) {
        this.m_fkClient = _fkClient;
    }

    public int getFkPaymentMethod() {
        return m_fkPaymentMethod;
    }
    public void setFkPaymentMethod(int _fkPaymentMethod) {
        this.m_fkPaymentMethod = _fkPaymentMethod;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        this.m_arrayOrderDetails.add(orderDetail);
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


    public Order(Date p_dateOrder, TypeOrder p_typeOrder, Status p_status, double p_totalPrice) {
        setDateOrder(p_dateOrder);
        setTypeOrder(p_typeOrder);
        setStatus(p_status);
        setTotalPrice(p_totalPrice);
        m_arrayOrderDetails = new ArrayList<>();
    }

    public Order(int p_Id, Date p_dateOrder, TypeOrder p_typeOrder, Status p_status, double p_totalPrice,
                 int p_fkEstablishment, int p_fkEmployee, int p_fkClient, int p_fkPaymentMethod,
                 ArrayList<OrderDetail> orderDetails) {
        setId(p_Id);
        setDateOrder(p_dateOrder);
        setTypeOrder(p_typeOrder);
        setStatus(p_status);
        setTotalPrice(p_totalPrice);
        setFkEstablishment(p_fkEstablishment);
        setFkEmployee(p_fkEmployee);
        setFkClient(p_fkClient);
        setFkPaymentMethod(p_fkPaymentMethod);
        m_arrayOrderDetails = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{ ")
                .append("ID=").append(getId())
                .append(", Date=").append(getDateOrder())
                .append(", Type=").append(getTypeOrder())
                .append(", Status=").append(getStatus())
                .append(", Total Price=").append(getTotalPrice()).append("€")
                .append(", Establishment ID=").append(getFkEstablishment())
                .append(", Employee ID=").append(getFkEmployee())
                .append(", Client ID=").append(getFkClient())
                .append(", Payment Method ID=").append(getFkPaymentMethod());

        // Mostrar detalles del pedido
        sb.append(", Order Details=[");
        for (OrderDetail detail : getOrderDetails()) {
            sb.append(detail).append(", ");
        }
        sb.append("]");

        // Mostrar información de objetos relacionados si existen
        if (m_establishment != null) sb.append(", Establishment=").append(m_establishment.getName());
        if (m_employee != null) sb.append(", Employee=").append(m_employee.getFirstName()).append(" ").append(m_employee.getLastName());
        if (m_client != null) sb.append(", Client=").append(m_client.getFirstName()).append(" ").append(m_client.getLastName());
        if (m_paymentMethod != null) sb.append(", Payment Method=").append(m_paymentMethod.getName());

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

    public static String toArrayJSon(ArrayList<Order> order) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(order);

        return resp;
    }
}
