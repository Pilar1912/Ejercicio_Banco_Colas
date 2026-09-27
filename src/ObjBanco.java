public class ObjBanco {

    private String Identificacion;
    private String Nombre;
    private String TipoTramite;
    private int Edad;
    private String CondicionAt;
    private int Turno;

    public ObjBanco() {

    }

    public ObjBanco(String identificacion, String nombre, String tipoTramite, int edad, String condicionAt, int turno) {
        Identificacion = identificacion;
        Nombre = nombre;
        TipoTramite = tipoTramite;
        Edad = edad;
        CondicionAt = condicionAt;
        Turno = turno;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipoTramite() {
        return TipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        TipoTramite = tipoTramite;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getCondicionAt() {
        return CondicionAt;
    }

    public void setCondicionAt(String condicionAt) {
        CondicionAt = condicionAt;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

    
    
}
