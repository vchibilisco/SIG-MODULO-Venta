/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

/**
 *
 * @author vicente-dell
 */
public class CLIENTE {

    private String cuit;
    private String razonSocial;
    private String rs;
    private String telefono;
    private String domicilio;
    private UBICACION ubicacion;

    public CLIENTE(String cuit, String razonSocial, String rs, String telefono, String domicilio, String pais, String provincia, String localidad, Integer cp) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.rs = rs;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.ubicacion = new UBICACION(cp, localidad, provincia, pais);
    }

    public CLIENTE() {
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public UBICACION getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UBICACION ubicacion) {
        this.ubicacion = ubicacion;
    }
}
