package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface iMotorSql {

    //Método para conectar
    public void connect();

    public boolean execute(PreparedStatement stmt);

    public boolean execute();

    //Método para ejecutar
    public int execute(String sql);

    //Me devuelve un conjunto de resultados
    public ResultSet executeQuery(String sql);

    //Método para desconectarse
    public void disconnect();

    public Connection getConnection();
    public void setPreparedStatement(PreparedStatement stmt);
}
