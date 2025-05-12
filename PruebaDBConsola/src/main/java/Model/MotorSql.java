package Model;

import java.sql.*;

public class MotorSql implements iMotorSql{

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private Connection m_Connection;
    private Statement m_Statement;
    private PreparedStatement m_PreparedStatement;
    private ResultSet m_ResultSet;
    private static final String MYSQL_URL= "jdbc:mysql://db-lingoburguer.cy1zrbhftco0.us-east-1.rds.amazonaws.com:3306/LingoBurguer";
    private static final String MYSQL_USER = "admin";
    private static final String MYSQL_PASS = "lingoburguer04";


    @Override
    public void connect() {
        try
        {
            Class.forName(DRIVER_NAME); //Me permite instanciar una clase para poder utilizarla
            //Class.forName("DRIVER_NAME").newInstance();
            m_Connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASS); // gestiona la conexión
            m_Statement =m_Connection.createStatement();
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException();
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx.getMessage());
        }
    }

    @Override
    public boolean execute(PreparedStatement stmt) {
        setPreparedStatement(stmt);
        return execute();
    }

    @Override
    public boolean execute() {
        boolean bRet=false;
        if(m_PreparedStatement != null)
        {
            try{
                bRet=m_PreparedStatement.execute();
            }
            catch(SQLException sqlEx)
            {

            }
        }
        return bRet;
    }

    @Override
    public int execute(String sql) {
        return 0;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try
        {
            m_ResultSet=m_Statement.executeQuery(sql);
        }
        catch(SQLException sqlEx)
        {
            System.out.println(sqlEx.getMessage());
            m_ResultSet = null;
        }
        return m_ResultSet;
    }

    @Override
    public void disconnect() {
        try
        {
            if(m_ResultSet !=null && !m_ResultSet.isClosed())
            {
                m_ResultSet.close();
            }
            if (m_Statement!=null && !m_Statement.isClosed())
            {
                m_Statement.close();
            }
            if (m_Connection!=null && !m_Connection.isClosed())
            {
                m_Connection.close();
            }
        }
        catch(SQLException sqlEx)
        {
            System.out.println(sqlEx.getMessage());
        }
    }

    public Connection getConnection()
    {
        return m_Connection;
    }


    public void setPreparedStatement(PreparedStatement stmt)
    {
        m_PreparedStatement = stmt;
    }
}
