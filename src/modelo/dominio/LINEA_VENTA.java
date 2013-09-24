package modelo.dominio;

import modelo.dominio.PRODUCTO;
import vista.recursos.Formato;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class LINEA_VENTA {

    private Integer CUP;
    private String descripcion;
    private Integer cantidad;
    private Float precio_Unitario;
    private Float precio_Total;
    private PRODUCTO m_PRODUCTO;

    public LINEA_VENTA(PRODUCTO producto, Integer cantidad) {
        this.CUP = producto.getCUP();
        if (!producto.getM_UNIDAD().equals("No posee")) {
            this.descripcion = producto.getM_MARCA() + " " + producto.getDescripcion() + " " + producto.getCap_Vol() + " " + producto.getM_UNIDAD();
        } else {
            this.descripcion = producto.getM_MARCA() + " " + producto.getDescripcion();
        }
        this.cantidad = cantidad;
        this.precio_Unitario = producto.getPrecio_Unitario();
        this.subtotal();
    }

    public Integer getCUP() {
        return CUP;
    }

    public void setCUP(Integer CUP) {
        this.CUP = CUP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(Float precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public Float getPrecio_Total() {
        return precio_Total;
    }

    public void setPrecio_Total(Float precio_Total) {
        this.precio_Total = precio_Total;
    }

    public PRODUCTO getM_PRODUCTO() {
        return m_PRODUCTO;
    }

    public void setM_PRODUCTO(PRODUCTO m_PRODUCTO) {
        this.m_PRODUCTO = m_PRODUCTO;
    }

    public void finalize() throws Throwable {
    }

    /**
     *
     * @param PRODUCTO
     * @param int
     */
    private void subtotal() {
        this.precio_Total = Float.parseFloat(Formato.precio().format(this.cantidad * this.precio_Unitario));
    }
}//end LINEA_VENTA