
package co.edu.uniminuto.entity;


public class Estudiante {
    
    private String estudianteNombre;
    private String estudianteApellidos;
    private int estudianteEdad;
    private String estudianteDireccion;
    private int estudianteTelefono;
    private String estudianteGrado;
    private int estudianteCurso;
    private String estudianteJornada;
    private String estudianteCorreo; 
    private int estudianteStatus;

    public Estudiante() {
    }

    public Estudiante(String estudianteNombre, String estudianteApellidos, int estudianteEdad, String estudianteDireccion, int estudianteTelefono, String estudianteGrado, int estudianteCurso, String estudianteJornada, String estudianteCorreo, int estudianteStatus) {
        this.estudianteNombre = estudianteNombre;
        this.estudianteApellidos = estudianteApellidos;
        this.estudianteEdad = estudianteEdad;
        this.estudianteDireccion = estudianteDireccion;
        this.estudianteTelefono = estudianteTelefono;
        this.estudianteGrado = estudianteGrado;
        this.estudianteCurso = estudianteCurso;
        this.estudianteJornada = estudianteJornada;
        this.estudianteCorreo = estudianteCorreo;
        this.estudianteStatus = estudianteStatus;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public String getEstudianteApellidos() {
        return estudianteApellidos;
    }

    public void setEstudianteApellidos(String estudianteApellidos) {
        this.estudianteApellidos = estudianteApellidos;
    }

    public int getEstudianteEdad() {
        return estudianteEdad;
    }

    public void setEstudianteEdad(int estudianteEdad) {
        this.estudianteEdad = estudianteEdad;
    }

    public String getEstudianteDireccion() {
        return estudianteDireccion;
    }

    public void setEstudianteDireccion(String estudianteDireccion) {
        this.estudianteDireccion = estudianteDireccion;
    }

    public int getEstudianteTelefono() {
        return estudianteTelefono;
    }

    public void setEstudianteTelefono(int estudianteTelefono) {
        this.estudianteTelefono = estudianteTelefono;
    }

    public String getEstudianteGrado() {
        return estudianteGrado;
    }

    public void setEstudianteGrado(String estudianteGrado) {
        this.estudianteGrado = estudianteGrado;
    }

    public int getEstudianteCurso() {
        return estudianteCurso;
    }

    public void setEstudianteCurso(int estudianteCurso) {
        this.estudianteCurso = estudianteCurso;
    }

    public String getEstudianteJornada() {
        return estudianteJornada;
    }

    public void setEstudianteJornada(String estudianteJornada) {
        this.estudianteJornada = estudianteJornada;
    }

    public String getEstudianteCorreo() {
        return estudianteCorreo;
    }

    public void setEstudianteCorreo(String estudianteCorreo) {
        this.estudianteCorreo = estudianteCorreo;
    }

    public int getEstudianteStatus() {
        return estudianteStatus;
    }

    public void setEstudianteStatus(int estudianteStatus) {
        this.estudianteStatus = estudianteStatus;
    }
    
    
    
    
}
