/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dominio.CLIENTE;
import modelo.dominio.UBICACION;

/**
 *
 * @author vicente-dell
 */
public class DBCliente extends Entidad {

    private static ArrayList<CLIENTE> listaCliente;

    public static ArrayList<CLIENTE> recuperarListaCliente() {
        try {
            listaCliente = new ArrayList<>();
            ResultSet rs = consulta("viewcliente");
            while (rs.next()) {
                CLIENTE cliente = new CLIENTE();
                cliente.setCuit(rs.getString("CUIT"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                cliente.setRs(rs.getString("tipo_rs"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setUbicacion(new UBICACION());
                cliente.getUbicacion().setCP(rs.getInt("cp"));
                cliente.getUbicacion().setLocalidad(rs.getString("localidad"));
                cliente.getUbicacion().setProvincia(rs.getString("provincia"));
                cliente.getUbicacion().setPais(rs.getString("pais"));
                listaCliente.add(cliente);
            }
            return listaCliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return listaCliente;
        }
    }
}
