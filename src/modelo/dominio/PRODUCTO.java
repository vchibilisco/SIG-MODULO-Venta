package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class PRODUCTO {

    private Integer CUP;
    private String descripcion;
    private Float cap_Vol;
    private Float precio_Unitario;
    private Integer stock;
    private String m_RUBRO;
    private String m_UNIDAD;
    private String m_MARCA;

    public PRODUCTO() {
        this.CUP = 0;
        this.descripcion = "";
        this.cap_Vol = (float) 0.0;
        this.precio_Unitario = (float) 0.0;
        this.stock = 0;
        this.m_RUBRO = "";
        this.m_UNIDAD = "";
        this.m_MARCA = "";
    }

    public PRODUCTO(Integer cup, String descripcion, Float cap_vol, Float pre_Unitario, Integer stock, String m_Rubro, String m_Marca, String m_Unidad) {
        this.CUP = cup;
        this.descripcion = descripcion;
        this.cap_Vol = cap_vol;
        this.precio_Unitario = pre_Unitario;
        this.stock = stock;
        this.m_RUBRO = m_Rubro;
        this.m_MARCA = m_Marca;
        this.m_UNIDAD = m_Unidad;
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

    public Float getCap_Vol() {
        return cap_Vol;
    }

    public void setCap_Vol(Float cap_Vol) {
        this.cap_Vol = cap_Vol;
    }

    public Float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(Float precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getM_RUBRO() {
        return m_RUBRO;
    }

    public void setM_RUBRO(String m_RUBRO) {
        this.m_RUBRO = m_RUBRO;
    }

    public String getM_UNIDAD() {
        return m_UNIDAD;
    }

    public void setM_UNIDAD(String m_UNIDAD) {
        this.m_UNIDAD = m_UNIDAD;
    }

    public String getM_MARCA() {
        return m_MARCA;
    }

    public void setM_MARCA(String m_MARCA) {
        this.m_MARCA = m_MARCA;
    }

    public void finalize() throws Throwable {
    }
}//end PRODUCTOS