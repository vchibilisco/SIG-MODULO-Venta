/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.Controlador_DB;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dominio.EMPLEADO;

/**
 *
 * @author vicente-ub1204
 */
public class DBUsserPass extends Entidad {

    public static boolean permiso(String user, EMPLEADO logeo) {
        try {
            ResultSet rs = Controlador_DB.getConexion().getStatement().executeQuery("SELECT * FROM sig.viewempleado WHERE viewempleado.usuario=" + quotate(user) + " AND viewempleado.eliminar = 1");
            if (!user.equals("root")) {
                while (rs.next()) {
                    logeo.setLegajo(rs.getInt("legajo"));
                    logeo.setApellido(rs.getString("apellido"));
                    logeo.setNombre(rs.getString("nombre"));
                    logeo.setDNI(rs.getInt("dni"));
                    logeo.setCuil(rs.getString("cuil"));
                    logeo.setPuestoTrabajo(rs.getString("categoria"));
                    logeo.setUser(user);
                    return true;
                }
            } else {
                return true;
            }
            return false;
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
