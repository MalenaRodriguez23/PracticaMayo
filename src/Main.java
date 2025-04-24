import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Persona p= new Persona("Marlena Rodríguez",98);
        String json=gson.toJson(p);
        System.out.println(json);
    }
}