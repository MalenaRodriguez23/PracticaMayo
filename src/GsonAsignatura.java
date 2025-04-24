import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GsonAsignatura {
    public static void main(String[] args){
        Gson gson = new Gson();

        Estudiante e1= new Estudiante("Maria", 19);
        Estudiante e2= new Estudiante("Juan", 20);
        Estudiante e3= new Estudiante("Jose", 21);
        List<Estudiante> list= new ArrayList<Estudiante>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        Asignatura asignatura= new Asignatura("Mate", list);

        //Guardar en JSON
        String ruta="asignatura.json";
        GsonUtilEjemplo.guardarObjetoEnArchivo(ruta, asignatura);
        GsonUtilEjemplo.cargarObjetoDesdeArchivo(ruta,Asignatura.class);

    }
}
