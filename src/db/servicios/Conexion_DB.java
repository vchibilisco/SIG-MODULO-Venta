/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vicente
 */
public abstract class Conexion_DB {

    private Connection conexion;
    private Statement statement;
    private String servidor = "192.168.1.102:3306";
    private String dataBase = "sig";

    public abstract void conectar(String user, String pass) throws SQLException, ClassNotFoundException;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getServidor() {
        return servidor;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
