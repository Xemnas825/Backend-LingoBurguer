package model;

import java.sql.ResultSet;

public interface iMotorSql {

    //Método para conectar
    public void connect();

    //Método para ejecutar
    public int execute(String sql);

    //Me devuelve un conjunto de resultados
    public ResultSet executeQuery(String sql);

    //Método para desconectarse
    public void disconnect();
}
