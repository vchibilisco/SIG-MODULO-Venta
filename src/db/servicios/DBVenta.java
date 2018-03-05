/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.Controlador_DB;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dominio.LINEA_VENTA;
import modelo.dominio.VENTA;

/**
 *
 * @author vicente
 */
public class DBVenta extends Entidad {

    public static void confirmarVenta(VENTA venta) {
        ArrayList<LINEA_VENTA> linea_venta = venta.getLista_Venta();
        try {
            CallableStatement venta_rutina = (CallableStatement) Controlador_DB.getConexion().getConexion().prepareCall("CALL NUEVA_VENTA(?,?,?,?,?)");            
            venta_rutina.setInt("numVenta", venta.getNumero_Factura());
            venta_rutina.setString("cliente", venta.getCliente().getRazonSocial());
            venta_rutina.setInt("leg", venta.getEmpleado().getLegajo());
            venta_rutina.setDate("fech", venta.getFecha());
            venta_rutina.setFloat("preTot", venta.getPrecio_Total());
            if (!venta_rutina.execute()) {
                DBLinea_Venta.agregarLinea(linea_venta, venta);
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo la Venta realizada", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guarda en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static Integer numFactura() {
        ResultSet rs = consulta("venta");
        Integer num_fact;
        try {
            if (rs.next() != false) {
                rs.last();
                num_fact = Integer.parseInt(rs.getString("num_venta"));
                rs.close();
                num_fact = num_fact + 1;
                return num_fact;
            } else {
                num_fact = 1;
                rs.close();
                return num_fact;
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
