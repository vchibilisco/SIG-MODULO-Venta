package modelo.dominio;

/**
 * @author vicenteW7 noteb
 * @version 1.0
 * @created 19-mar-2013 08:18:15 p.m.
 */
public class UBICACION {

    private Integer CP;
    private String localidad;
    private String provincia;
    private String pais;

    public UBICACION() {
    }

    /**
     *
     * @param CP
     * @param localidad
     * @param provincia
     * @param pais     
     */
    public UBICACION(Integer CP, String localidad, String provincia, String pais) {
        this.CP = CP;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Integer getCP() {
        return CP;
    }

    public void setCP(Integer CP) {
        this.CP = CP;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}//end UBICACION