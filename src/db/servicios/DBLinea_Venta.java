/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.Controlador_DB;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dominio.LINEA_VENTA;
import modelo.dominio.VENTA;

/**
 *
 * @author vicente-ub1204
 */
public class DBLinea_Venta extends Entidad {

    private static String query;

    public static void agregarLinea(ArrayList<LINEA_VENTA> lista_venta, VENTA venta) {
        try {
            for (LINEA_VENTA linea : lista_venta) {
                CallableStatement lin_vent_rutina = (CallableStatement) Controlador_DB.getConexion().getConexion().prepareCall("CALL LINEA_VENTA(?,?,?,?,?,?)");
                lin_vent_rutina.setInt("numVenta", venta.getNumero_Factura());
                lin_vent_rutina.setInt("cupPro", linea.getCUP());
                lin_vent_rutina.setString("descr", linea.getDescripcion());
                lin_vent_rutina.setInt("cant", linea.getCantidad());
                lin_vent_rutina.setFloat("preUni", linea.getPrecio_Unitario());
                lin_vent_rutina.setFloat("preTot", linea.getPrecio_Total());
                if (!lin_vent_rutina.execute()) {
                    DBProducto.actualizarStock(linea.getCUP(), linea.getCantidad());
                } else {
                    JOptionPane.showMessageDialog(null, "No se guardo la Venta realizada", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
    }
}
