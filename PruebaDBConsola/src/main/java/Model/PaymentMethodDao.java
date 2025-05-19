package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentMethodDao implements iDao{

    private final String SQL_FIND= "SELECT * from payment_methods WHERE 1=1 ";
    private iMotorSql motorSql;
    public PaymentMethodDao()
    {
        motorSql = new MotorSql();

    }

    @Override
    public int add(Object bean) {
        return 0;
    }

    @Override
    public int delete(Object e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList findAll(Object bean) {

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
        String sql = SQL_FIND;
        try {
            motorSql.connect();
            if (bean != null) {
                PaymentMethod paymentMethod = (PaymentMethod) bean;

                if (paymentMethod.getId() >= 0) {
                    sql += " AND payment_method_id ='" + paymentMethod.getId() + "'";
                }
                if (paymentMethod.getName() != null && paymentMethod.getName() != "") {
                    sql += " AND name_method ='" + paymentMethod.getName() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                PaymentMethod paymentMethodBd = new PaymentMethod(
                        rs.getInt("payment_method_id"),
                        rs.getString("name_method"));
                paymentMethods.add(paymentMethodBd);
            }
        }
        catch (SQLException sqlEx)
            {
                System.out.println(sqlEx);
            }

            return paymentMethods;
    }
}
