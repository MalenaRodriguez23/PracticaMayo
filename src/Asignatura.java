import java.util.List;

public class Asignatura {
    private String nombreAsignatura;
    private List<Estudiante> estudiantes;

    public Asignatura(String nombreAsignatura, List<Estudiante> estudiantes) {
        this.nombreAsignatura = nombreAsignatura;
        this.estudiantes = estudiantes;
    }
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
