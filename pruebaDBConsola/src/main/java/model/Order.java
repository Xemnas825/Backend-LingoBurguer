package model;


public class Order {

    private int m_iId;
    private String m_strDateOrder;
    // type_order ENUM('online', 'physical'),
    // status ENUM('local', 'online', 'take_away')
    private double m_dblTotalPrice;
    private Establishment m_fkEstablishment;


}
