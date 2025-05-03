import com.google.gson.Gson;


public class GsonEj1 {
    public static void main(String[] args){
        Gson gson=new Gson();
        //Hoja1
        //crear objetos
        Circle circle=new Circle();
        Employee empleado=new Employee(1,"Malena","Rodriguez",1000);

        String rutaArchivo1="circles.json";
        String rutaArchivo2="empleado.json";

        //Guardar en JSON
        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo1, circle);
        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo2, empleado);

        //Leer desde JSON

        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo1,Circle.class);
        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo2,Employee.class);

        //Hoja2
        Persona persona=new Persona("Lidia",18);
        Estudiante estudiante=new Estudiante("Carmen",55);

        String rutaArchivo3="personas.json";
        String rutaArchivo4="estudiantes.json";

        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo3, persona);
        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo4, empleado);

        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo3,Persona.class);
        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo4,Employee.class);

    }
}
