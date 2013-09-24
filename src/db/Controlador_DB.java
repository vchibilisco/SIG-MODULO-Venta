/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.servicios.Conexion_DB;
import db.servicios.DBCliente;
import db.servicios.DBEmpleado;
import db.servicios.DBProducto;
import db.servicios.DBUsserPass;
import db.servicios.DBVenta;
import db.servicios.MySql;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dominio.CLIENTE;
import modelo.dominio.EMPLEADO;
import modelo.dominio.PRODUCTO;
import modelo.dominio.VENTA;

/**
 *
 * @author vicente
 */
public class Controlador_DB {

    private static Conexion_DB conexion;

    public Controlador_DB() {
    }

    public boolean conectar(String user, String pass, EMPLEADO logeo) {
        conexion = new MySql();
        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "No se logro conectar con la Base de Datos. \nNo se puede iniciar la Aplicación.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                conexion.conectar(user, pass);
                if (DBUsserPass.permiso(user, logeo)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no tiene permiso de acceso.", "ERROR", JOptionPane.WARNING_MESSAGE);
                    getConexion().getConexion().close();
                    return false;
                }
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No se logro conectar con la Base de Datos. \nNo se puede iniciar la Aplicación.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public static Conexion_DB getConexion() {
        return conexion;
    }

    public static Integer getNumFact() {
        return DBVenta.numFactura();
    }

    public String getNomEmpleado() {
        return DBEmpleado.nombEmpleado();
    }

    public ArrayList<PRODUCTO> recuperarListaProducto() {
        return DBProducto.recuperarListaProducto();
    }

    public  ArrayList<CLIENTE> recuperarListaCliente() {
        return DBCliente.recuperarListaCliente();
    }
    
    public void confirmarVenta(VENTA venta) {
        DBVenta.confirmarVenta(venta);
    }
}
