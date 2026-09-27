public class ObjBanco {

    private int Turno;
    private String Identificacion;
    private String Nombre;
    private int TipoTramite;
    private int Edad;
    private int CondicionAt;
    private int Estado;

    public ObjBanco() {

    }

    public ObjBanco(int turno, String identificacion, String nombre, int tipoTramite, int edad, int condicionAt, int estado) {
        Turno = turno;
        Identificacion = identificacion;
        Nombre = nombre;
        TipoTramite = tipoTramite;
        Edad = edad;
        CondicionAt = condicionAt;
        Estado = estado;
    }

     public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
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

    public int getTipoTramite() {
        return TipoTramite;
    }

    public void setTipoTramite(int tipoTramite) {
        TipoTramite = tipoTramite;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getCondicionAt() {
        return CondicionAt;
    }

    public void setCondicionAt(int condicionAt) {
        CondicionAt = condicionAt;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    
    
}
