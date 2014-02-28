/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import db.Controlador_DB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dominio.PRODUCTO;

/**
 *
 * @author vicente
 */
public class DBProducto extends Entidad {
    
    private static ArrayList<PRODUCTO> lista_producto;
    private static String query;
    
    public static ArrayList<PRODUCTO> recuperarListaProducto() {
        DBProducto.lista_producto = new ArrayList<>();
        ResultSet rs = consulta("viewproducto");
        try {
            while (rs.next()) {
                PRODUCTO producto = new PRODUCTO();
                producto.setCUP(Integer.parseInt(rs.getString("CUP")));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCap_Vol(Float.parseFloat(rs.getString("pes_vol_long")));
                producto.setStock(Integer.parseInt(rs.getString("stock")));
                producto.setPrecio_Unitario(Float.parseFloat(rs.getString("precio_unitario")));
                producto.setM_MARCA(rs.getString("marca"));
                producto.setM_RUBRO(rs.getString("rubro"));
                producto.setM_UNIDAD(rs.getString("unidad"));
                DBProducto.lista_producto.add(producto);
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se logro recuperar los Productos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return DBProducto.lista_producto;
    }
    
    //=======Actualiza stock==================
    public static void actualizarStock(Integer cup, Integer stock) {
        try {
            CallableStatement actualizar_stock_rutina = (CallableStatement) Controlador_DB.getConexion().getConexion().prepareCall("CALL ACTUALIZAR_STOCK_PRODUCTO(?,?,?)");
            actualizar_stock_rutina.setInt("cups", cup);
            actualizar_stock_rutina.setInt("estock", stock);
            actualizar_stock_rutina.setString("opcion", "venta");
            actualizar_stock_rutina.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
