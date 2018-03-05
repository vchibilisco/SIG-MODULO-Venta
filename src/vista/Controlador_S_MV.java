/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Controlador_M;
import modelo.dominio.LINEA_VENTA;
import modelo.dominio.PRODUCTO;
import vista.interfaz.Busca;
import vista.interfaz.Venta;
import vista.interfaz.logeo.Logeo;
import vista.recursos.Formato;

/**
 *
 * @author vicente
 */
public class Controlador_S_MV {

    private static Venta venta;
    private static Busca buscar;
    private static Controlador_M controM;
    private static Logeo logeo;

    public static Venta getVenta() {
        return venta;
    }

    public static Busca getBuscar() {
        return buscar;
    }

    public static Controlador_M getControM() {
        return controM;
    }

    //logeo
    public static void iniciarApp() {
        Controlador_S_MV.logeo = new Logeo();
        Controlador_S_MV.logeo.setVisible(true);
    }

    public static void iniciaPrincipal(String user, String pass) {
        Controlador_S_MV.controM = new Controlador_M();
        if (Controlador_S_MV.controM.conectar(user, pass)) {
            Controlador_S_MV.logeo.dispose();
            Controlador_S_MV.controM.iniciaVenta();
            Controlador_S_MV.venta = new Venta();
            Controlador_S_MV.venta.setTitle(Controlador_S_MV.venta.getTitle() + " = Sesion abierta por: " + controM.getLogeo().getApellido() + " " + controM.getLogeo().getNombre());
            Controlador_S_MV.setNumeroFactura();
            Controlador_S_MV.venta.getTxtVendedor().setText(Controlador_S_MV.controM.getLogeo().getApellido() + " " + Controlador_S_MV.controM.getLogeo().getNombre());
            Controlador_S_MV.venta.getTxtNumFact().setText(String.valueOf(Formato.numFact(Controlador_S_MV.controM.getVenta().getNumero_Factura())));
            Controlador_S_MV.venta.setVisible(true);
        } else {
            Controlador_S_MV.logeo.iniciarComponentes();
        }
    }

    public static void setNumeroFactura() {
        Controlador_S_MV.controM.getVenta().setNumero_Factura(Controlador_S_MV.controM.getControDB().getNumFact());
    }

    public static void inciaBuscar() {
        Controlador_S_MV.buscar = new Busca(venta, true);
        Controlador_S_MV.buscar.setVisible(true);
    }

    public static void completarTablaBuscar(DefaultTableModel modelo) {
        if (!Controlador_S_MV.getControM().getLista_producto().isEmpty()) {
            for (PRODUCTO producto : Controlador_S_MV.getControM().getLista_producto()) {
                Object[] datosFilas = new Object[4];
                datosFilas[0] = producto.getCUP();
                if (!producto.getM_UNIDAD().equals("No posee")) {
                    datosFilas[1] = producto.getM_MARCA() + " " + producto.getDescripcion() + " " + producto.getCap_Vol() + " " + producto.getM_UNIDAD();
                } else {
                    datosFilas[1] = producto.getM_MARCA() + " " + producto.getDescripcion();
                }
                datosFilas[2] = producto.getStock();
                datosFilas[3] = producto.getPrecio_Unitario();
                modelo.addRow(datosFilas);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro ningun Producto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void cargarProducto(Integer cup, Integer cantidad) {
        boolean bandera = Controlador_S_MV.getControM().cargarProducto(cup, cantidad);
        if (bandera == false) {
            LINEA_VENTA linea_venta = Controlador_S_MV.getControM().getVenta().getM_LINEA_VENTA();
            Object[] fila = new Object[5];
            fila[0] = linea_venta.getCUP();
            fila[1] = linea_venta.getDescripcion();
            fila[2] = linea_venta.getPrecio_Unitario();
            fila[3] = linea_venta.getCantidad();
            fila[4] = Formato.cambioCarater().format(linea_venta.getPrecio_Total());
            Controlador_S_MV.getVenta().getModelo().addRow(fila);
            Controlador_S_MV.getVenta().setearModelo();
            Controlador_S_MV.getVenta().getTxtTotal().setText(String.valueOf(Formato.cambioCarater().format(Controlador_S_MV.getControM().getVenta().getPrecio_Total())));
        }
    }

    public static void confirmarVenta(Date fecha, String cliente) {
        Controlador_S_MV.getControM().confirmar(fecha, cliente);
    }

    public static void eliminar(Integer cup, Integer posProd) {
        Controlador_S_MV.getControM().eliminar(cup);
        Controlador_S_MV.getVenta().getModelo().removeRow(posProd);
        Controlador_S_MV.getVenta().setearModelo();
        Controlador_S_MV.getVenta().getTxtTotal().setText(String.valueOf(Formato.cambioCarater().format(Controlador_S_MV.getControM().getVenta().getPrecio_Total())));
    }

    public static void cerrarDB() {
        Controlador_S_MV.getControM().cerrarDB();
    }

    public static void getListaCliente(JComboBox listaCliente) {
        Controlador_S_MV.getControM().getListaCliente(listaCliente);
    }
    //------------Ver Reporte-------------

    public static void verReporte(Integer numeroFactura) {
        Controlador_S_MV.getControM().verReporte(numeroFactura).setVisible(true);
    }
}
