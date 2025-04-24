import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class GsonUtilEjemplo {
    //Metodo para guardar un objeto en un archivo JSON
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto){
        Gson gson=new Gson();
        try(FileWriter writer= new FileWriter(rutaArchivo)){
            gson.toJson(objeto, writer);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //Metodo para cargar un objeto desde un archivo JSON
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
        //Crear una instancia del objeto Usuario
        Usuario usuario=new Usuario("Juan",89,"juan@example.com");

        //Ruta del archivo donde se guardará el objeto
        String rutaArchivo="usuario.json";

        //Guardar el objeto Usuario en un archivo JSON
        guardarObjetoEnArchivo(rutaArchivo,usuario);

        //Cargar el objeto usuario desde un archivo JSON
        Usuario usuarioCargado= cargarObjetoDesdeArchivo(rutaArchivo,Usuario.class);

        if(usuarioCargado!=null){
            System.out.println("Usuario cargado"+ usuarioCargado.nombre);
        }
    }
    //Clase usuario
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
    }
}
