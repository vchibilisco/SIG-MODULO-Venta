/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.Controlador_DB;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vicente
 */
public class Entidad {

    public static String quotate(String content) {
        return "'" + content + "'";
    }

    public static void seleccionarTablaBD(String tabla) {
        System.out.println("Seleccionar tabla: " + tabla);
        try {
            Controlador_DB.getConexion().getStatement().executeQuery("Select * from " + tabla);
        } catch (SQLException e) {
            System.out.println("Error al seleccionar");
        }
    }

    public static ResultSet consulta(String entidad) {
        ResultSet rs;
        try {
            rs = Controlador_DB.getConexion().getStatement().executeQuery("Select * from " + entidad);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta");
        }
        return null;
    }
}
