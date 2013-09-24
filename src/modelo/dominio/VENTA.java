package modelo.dominio;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class VENTA {

    private Integer numero_Factura;
    private Date fecha;
    private Float precio_Total;
    private ArrayList<LINEA_VENTA> lista_Venta;
    private LINEA_VENTA m_LINEA_VENTA;
    private CLIENTE cliente;
    private EMPLEADO empleado;

    public VENTA() {
        this.lista_Venta = new ArrayList<>();
        this.precio_Total = (float) 0.0;
    }

    public EMPLEADO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EMPLEADO empleado) {
        this.empleado = empleado;
    }

    public CLIENTE getCliente() {
        return cliente;
    }

    public void setCliente(CLIENTE cliente) {
        this.cliente = cliente;
    }

    public Integer getNumero_Factura() {
        return numero_Factura;
    }

    public void setNumero_Factura(Integer numero_Factura) {
        this.numero_Factura = numero_Factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getPrecio_Total() {
        return precio_Total;
    }

    public void setPrecio_Total(Float precio_Total) {
        this.precio_Total = precio_Total;
    }

    public LINEA_VENTA getM_LINEA_VENTA() {
        return m_LINEA_VENTA;
    }

    public void setM_LINEA_VENTA(LINEA_VENTA m_LINEA_VENTA) {
        this.m_LINEA_VENTA = m_LINEA_VENTA;
    }

    public ArrayList<LINEA_VENTA> getLista_Venta() {
        return lista_Venta;
    }

    /**
     *
     * @param int
     * @param PRODUCTO
     */
    public LINEA_VENTA cargar(int cantidad, PRODUCTO producto) {
        this.m_LINEA_VENTA = new LINEA_VENTA(producto, cantidad);
        this.lista_Venta.add(m_LINEA_VENTA);
        this.actualizarTotal();
        return this.m_LINEA_VENTA;
    }

    public void actEliminar() {
        actualizarTotal();
    }

    private void actualizarTotal() {
        Float precio = Float.parseFloat("0.00");
        for (LINEA_VENTA linea : this.getLista_Venta()) {
            precio = precio + linea.getPrecio_Total();
            this.setPrecio_Total(precio);
        }
    }
}//end VENTA