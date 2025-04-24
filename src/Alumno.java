public class Alumno {
    private int edad;
    private String name;
    private int curso;

    public Alumno(String name, int edad, int curso) {
        this.edad=edad;
        this.name=name;
        this.curso=curso;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }

}
