package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OrderDetail implements iModel{
    private int m_iId;
    private int m_iQuantity;
    private double m_dblUnitPrice;
    private String m_strNotes;
    private int m_fkOrderId;
    private int m_fkProductId;

    private Order order;
    private Product product;

    public int getId() {
        return m_iId;
    }
    public void setId(int m_iId) {
        this.m_iId = m_iId;
    }

    public int getQuantity() {
        return m_iQuantity;
    }
    public void setQuantity(int m_iQuantity) {
        this.m_iQuantity = m_iQuantity;
    }

    public double getUnitPrice() {
        return m_dblUnitPrice;
    }
    public void setUnitPrice(double m_dblUnitPrice) {
        this.m_dblUnitPrice = m_dblUnitPrice;
    }

    public String getNotes() {
        return m_strNotes;
    }
    public void setNotes(String m_strNotes) {
        this.m_strNotes = m_strNotes;
    }

    public int getFkOrderId() { return m_fkOrderId; }
    public void setFkOrderId(int _fkOrderId) { this.m_fkOrderId = _fkOrderId; }

    public int getFkProductId() { return m_fkProductId; }
    public void setFkProductId(int _fkProductId) { this.m_fkProductId = _fkProductId; }

    // 🔹 Métodos para asignar objetos y actualizar la FK automáticamente
    public Order getOrder() { return order;}
    public void setOrder(Order order) {
        this.order = order;
        if (order != null) {
            setFkOrderId(order.getId()); // Actualiza la FK también
        }
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {
            setFkProductId(product.getId()); // Actualiza la FK también
        }
    }

    public OrderDetail(int id, int quantity, double unitPrice, String notes, int order, int product) {
        setId(id);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setNotes(notes);
        setFkOrderId(order);
        setFkProductId(product);
    }

    // 🔹 Constructor cuando se crea un nuevo detalle
    public OrderDetail(int quantity, double unitPrice, String notes, int order, int product) {
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setNotes(notes);
        setFkOrderId(order);
        setFkProductId(product);
    }

    @Override
    public String toString() {
        return "OrderDetail{ ID=" + getId() +
                ", Quantity=" + getQuantity() +
                ", Unit Price=" + getUnitPrice() + "€" +
                ", Notes='" + getNotes() + '\'' +
                ", fkOrderId=" + getFkOrderId() +
                ", fkProductId=" + getFkProductId() +
                (order != null ? ", Order=" + order.getId() : "") +
                (product != null ? ", Product=" + product.getName() : "") +
                " }";
    }

    @Override
    public String fromArrayToJson(ArrayList bean) {
        return "";
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return "";
    }

    public static String toArrayJSon(ArrayList<OrderDetail> orderDetail) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(orderDetail);

        return resp;
    }
}
