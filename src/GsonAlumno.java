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
            System.out.println("Uso correcto");
            return;
        }
        String operacion=args[0];
        String fichero=args[1];
        Gson gson=new Gson();
        try{
            if("init".equals(operacion)){
                Alumno alumno=new Alumno("Malena",12,9);
                try(FileWriter fw=new FileWriter(fichero)){
                    gson.toJson(alumno,fw);
                    System.out.println("Archivo creado con éxito");
                }
            }
            else if("show".equals(operacion)){
                try(FileReader fr=new FileReader(fichero)){
                    Alumno alumno=gson.fromJson(fr,Alumno.class);
                    System.out.println("Datos del alumno: "+alumno);
                }
            }
            else{
                System.out.println("Error: Operación no reconocida.");
            }
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
