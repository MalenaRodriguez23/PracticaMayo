import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSoloLectura {
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto){
        Gson gson=new Gson();
        try(FileWriter writer= new FileWriter(rutaArchivo)){
            gson.toJson(objeto, writer);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase){
        Gson gson=new Gson();
        try( FileReader reader= new FileReader(rutaArchivo)){
            return gson.fromJson(reader, clase);
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[]args){
        GsonUtilEjemplo.Usuario usuario=new GsonUtilEjemplo.Usuario("Juan",89,"juan@example.com");

        String rutaArchivo="usuario.json";

        GsonUtilEjemplo.Usuario usuarioCargado= cargarObjetoDesdeArchivo(rutaArchivo, GsonUtilEjemplo.Usuario.class);

        if(usuarioCargado!=null){
            System.out.println("Usuario cargado"+ usuarioCargado.getNombre());
        }
    }
    static class Usuario{
        String nombre;
        int edad;
        String correo;
        public Usuario(String nombre, int edad, String correo){
            this.nombre=nombre;
            this.edad=edad;
            this.correo=correo;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getEdad() {
            return edad;
        }
        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getCorreo() {
            return correo;
        }
        public void setCorreo(String correo){
            this.correo = correo;
        }
    }

}
