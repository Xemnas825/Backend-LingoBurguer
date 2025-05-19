package Model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Order implements iModel {

    private int m_iId;
    public enum Status {local, take_away};
    private Status m_eStatus;
    private double m_dblTotalPrice;
    private int m_fkEstablishment;
    private int m_fkClient;
    private int m_fkPaymentMethod;

    private ArrayList<OrderDetail> m_arrayOrderDetails;
    private Establishment m_establishment;
    private Client m_client;
    private PaymentMethod m_paymentMethod;

    public int getId() {
        return m_iId;
    }
    public void setId(int _iId) {
        this.m_iId = _iId;
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


    public ArrayList<OrderDetail> getOrderDetails() {
        return m_arrayOrderDetails;
    }
    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.m_arrayOrderDetails = orderDetails;
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


    public Order(Status p_status, double p_totalPrice,
                 int p_fkEstablishment, int p_fkClient, int p_fkPaymentMethod,
                 ArrayList<OrderDetail> orderDetails) {
        setStatus(p_status);
        setTotalPrice(p_totalPrice);
        setFkEstablishment(p_fkEstablishment);
        setFkClient(p_fkClient);
        setFkPaymentMethod(p_fkPaymentMethod);
        setOrderDetails(orderDetails);
    }

    public Order(Status p_status, double p_totalPrice,
                 int p_fkEstablishment, int p_fkClient, int p_fkPaymentMethod) {

        setStatus(p_status);
        setTotalPrice(p_totalPrice);
        setFkEstablishment(p_fkEstablishment);
        setFkClient(p_fkClient);
        setFkPaymentMethod(p_fkPaymentMethod);
        m_arrayOrderDetails = new ArrayList<>();
    }


    public Order(int p_Id,Status p_status, double p_totalPrice,
                 int p_fkEstablishment, int p_fkClient, int p_fkPaymentMethod,
                 ArrayList<OrderDetail> orderDetails) {
        setId(p_Id);
        setStatus(p_status);
        setTotalPrice(p_totalPrice);
        setFkEstablishment(p_fkEstablishment);
        setFkClient(p_fkClient);
        setFkPaymentMethod(p_fkPaymentMethod);
        setOrderDetails(orderDetails);
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{ ")
                .append("ID=").append(getId())
                .append(", Status=").append(getStatus())
                .append(", Total Price=").append(getTotalPrice()).append("€")
                .append(", Establishment ID=").append(getFkEstablishment())
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
        if (m_client != null) sb.append(", Client=").append(m_client.getFirstName()).append(" ").append(m_client.getLastName());
        if (m_paymentMethod != null) sb.append(", Payment Method=").append(m_paymentMethod.getName());

        sb.append(" }");

        return sb.toString();
    }

    public void calculateTotalPrice() {
        double total = 0.0;
        if (m_arrayOrderDetails != null) {
            for (OrderDetail detail : m_arrayOrderDetails) {
                total += detail.getQuantity() * detail.getUnitPrice();
            }
        }
        setTotalPrice(total);
    }


    @Override
    public String fromArrayToJson(ArrayList bean) {
        return "";
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return "";
    }

    public static String toArrayJSon(ArrayList<Order> orders) {
        for (Order order : orders) {
            if (order.getOrderDetails() == null) {
                order.setOrderDetails(new ArrayList<OrderDetail>());
            }

            // Debug: imprimir la cantidad de detalles para ayudar a la depuración
            System.out.println("Order ID: " + order.getId() + " has " +
                    order.getOrderDetails().size() + " details to serialize");
        }
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(orders);

        return resp;
    }
}
