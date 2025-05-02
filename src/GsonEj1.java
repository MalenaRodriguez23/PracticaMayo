import com.google.gson.Gson;


public class GsonEj1 {
    public static void main(String[] args){
        Gson gson=new Gson();

        Circle circle=new Circle();
        Employee empleado=new Employee(1,"Malena","Rodriguez",1000);

        String rutaArchivo1="circles.json";
        String rutaArchivo2="empleado.json";

        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo1, circle);
        GsonUtilEjemplo.guardarObjetoEnArchivo(rutaArchivo2, empleado);


        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo1,Circle.class);
        GsonUtilEjemplo.cargarObjetoDesdeArchivo(rutaArchivo2,Employee.class);

    }
}
