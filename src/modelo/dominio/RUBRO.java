package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 31-dic-2012 04:02:34 p.m.
 */
public class RUBRO {

    private int id_Rubro;
    private char nombre;

    public RUBRO() {
    }

    public int getId_Rubro() {
        return id_Rubro;
    }

    public void setId_Rubro(int id_Rubro) {
        this.id_Rubro = id_Rubro;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public void finalize() throws Throwable {
    }
}//end RUBRO