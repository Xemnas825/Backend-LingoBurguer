package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PaymentMethod implements iModel {

    private int m_iId;
    private String m_strName;

    public int getId() {
        return m_iId;
    }

    public void setId(int _iId) {
        m_iId = _iId;
    }

    public String getName() {
        return m_strName;
    }

    public void setName(String _strName) {
        m_strName = _strName;
    }


    public PaymentMethod(int p_iId) {
        setId(p_iId);
    }

    public PaymentMethod(int p_iId, String p_strName) {
        setId(p_iId);
        setName(p_strName);
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "m_iId=" + m_iId +
                ", m_strName='" + m_strName + '\'' +
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

    public static String toArrayJSon(ArrayList<PaymentMethod> paymentMethod) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(paymentMethod);

        return resp;
    }

}
