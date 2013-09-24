/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class MySql extends db.servicios.Conexion_DB {

    @Override
    public void conectar(String user, String pass) throws SQLException, ClassNotFoundException {
        System.out.println("Conectando");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + getServidor() + "/" + getDataBase();
            setConexion(DriverManager.getConnection(url, user, pass));
            setStatement(getConexion().createStatement());
        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra Clase Driver Base de Datos");
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error Driver Base de Datos", "Advertencia", JOptionPane.ERROR_MESSAGE);
            throw (ex);
        } catch (SQLException ex) {
            System.err.println("No puede conectarse a la Base de Datos");
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar Base de Datos",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            throw (ex);
        }
    }
}
