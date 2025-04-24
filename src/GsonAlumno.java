import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GsonAlumno {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<args.length;i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);
        
        if(args.length!=2){
            System.out.println("Error: El argumento del archivo no es correcto");
        }
        String operacion=args[0];
        String fichero=args[1];
        Gson gson=new Gson();
        try{
            if(Objects.equals(operacion, "init")){
                Alumno alumno=new Alumno("Malena",12,9);
                try(FileWriter fw=new FileWriter(fichero)){
                    gson.toJson(alumno,fw);
                    System.out.println("Fichero creado con datos por defecto: ");
                }
            }
            if(Objects.equals(operacion, "show")){
                try(FileReader fr=new FileReader(fichero)){
                    Alumno alumno=gson.fromJson(fr,Alumno.class);
                    System.out.println("Datos leidos del fichero: "+alumno);
                }
            }
            else{
                System.out.println("Operación no reconocida.");
            }
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
