/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import java.sql.ResultSet;

/**
 *
 * @author vicente-ub1204
 */
public class DBEmpleado extends Entidad {

    public static String nombEmpleado() {
        ResultSet rs = consulta("empleado");
        String empleado = "";
        try {
            while (rs.next()) {
                empleado = rs.getString("apellido") + " " + rs.getString("nombre");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "No se encontro empleado";
        }
        return empleado;
    }
}
