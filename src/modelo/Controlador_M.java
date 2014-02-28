/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.Controlador_DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.dominio.CLIENTE;
import modelo.dominio.EMPLEADO;
import modelo.dominio.LINEA_VENTA;
import modelo.dominio.PRODUCTO;
import modelo.dominio.REPORTE;
import modelo.dominio.VENTA;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vicente
 */
public class Controlador_M {

    private VENTA venta;
    private ArrayList<PRODUCTO> lista_producto;
    private Controlador_DB controDB;
    private EMPLEADO logeo;

    public Controlador_M() {
        this.controDB = new Controlador_DB();
    }

    public boolean conectar(String user, String pass) {
        this.logeo = new EMPLEADO();
        return this.getControDB().conectar(user, pass, this.logeo);
    }

    public EMPLEADO getLogeo() {
        return logeo;
    }

    public Controlador_DB getControDB() {
        return controDB;
    }

    public VENTA getVenta() {
        return this.venta;
    }

    public Integer getNumFact() {
        return getControDB().getNumFact();
    }

    public ArrayList<PRODUCTO> getLista_producto() {
        this.lista_producto = this.getControDB().recuperarListaProducto();
        return this.lista_producto;
    }

    public void iniciaVenta() {
        this.venta = new VENTA();
        this.venta.setEmpleado(this.logeo);
    }

    public boolean cargarProducto(Integer cup, Integer cantidad) {
        boolean estaCargado = false;
        for (LINEA_VENTA linea : this.getVenta().getLista_Venta()) {
            if (linea.getCUP().equals(cup)) {
                estaCargado = true;
            }
        }
        if (estaCargado == false) {
            if (this.getVenta().getLista_Venta().isEmpty()) {
                for (PRODUCTO producto : this.getLista_producto()) {
                    if (producto.getCUP().equals(cup)) {
                        this.getVenta().setM_LINEA_VENTA(this.getVenta().cargar(cantidad, producto));
                    }
                }
            } else {
                for (PRODUCTO producto : this.getLista_producto()) {
                    if (producto.getCUP().equals(cup)) {
                        this.getVenta().setM_LINEA_VENTA(this.getVenta().cargar(cantidad, producto));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El Producto ya fue cargado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return estaCargado;
    }

    public void confirmar(Date fecha, String cliente) {
        java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
        for (CLIENTE clienteDB : this.getControDB().recuperarListaCliente()) {
            if (clienteDB.getRazonSocial().equals(cliente)) {
                this.getVenta().setCliente(clienteDB);
                this.getVenta().setFecha(fechaSql);
                this.getControDB().confirmarVenta(this.getVenta());
                break;
            }
        }

    }

    public void eliminar(Integer cup) {
        Iterator iteLinea = this.getVenta().getLista_Venta().iterator();
        while (iteLinea.hasNext()) {
            LINEA_VENTA linea = (LINEA_VENTA) iteLinea.next();
            if (cup.equals(linea.getCUP())) {
                iteLinea.remove();
            }
        }
        this.getVenta().actEliminar();
    }

    public void getListaCliente(JComboBox listaCliente) {
        for (CLIENTE cliente : this.getControDB().recuperarListaCliente()) {
            if (!cliente.getRs().equals("NO POSEE")) {
                listaCliente.addItem(cliente.getRazonSocial() + " " + cliente.getRs());
            } else {
                listaCliente.addItem(cliente.getRazonSocial());
            }
        }
    }

    public void cerrarDB() {
        try {
            Controlador_DB.getConexion().getConexion().close();
            System.out.println("Se cerro la conexion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se cerro de forma normal la aplicación", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Controlador_M.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JasperViewer verReporte(Integer numeroFactura) {
        REPORTE reporte = new REPORTE();
        return reporte.verReporte(numeroFactura);
    }
}
