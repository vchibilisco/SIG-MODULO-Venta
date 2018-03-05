package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class MARCA {

    private Integer id_Marca;
    private String nombre;

    public MARCA() {
    }

    public Integer getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(Integer id_Marca) {
        this.id_Marca = id_Marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void finalize() throws Throwable {
    }
}//end MARCA