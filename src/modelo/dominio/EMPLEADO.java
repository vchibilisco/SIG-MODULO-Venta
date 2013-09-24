package modelo.dominio;

/**
 * @author vicente
 * @version 1.0
 * @created 23-ene-2013 05:40:19 p.m.
 */
public class EMPLEADO {

    private Integer legajo;
    private Integer DNI;
    private String apellido;
    private String nombre;
    private String puestoTrabajo;
    private String user;
    private String cuil;
    private Float sueldoBase;

    public void EMPLEADO() {
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}//end EMPLEADO