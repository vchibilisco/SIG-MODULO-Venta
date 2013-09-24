package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class UNIDAD {

    private int id_Unidad;
    private char nombre;

    public UNIDAD() {
    }

    public int getId_Unidad() {
        return id_Unidad;
    }

    public void setId_Unidad(int id_Unidad) {
        this.id_Unidad = id_Unidad;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public void finalize() throws Throwable {
    }
}//end UNIDAD