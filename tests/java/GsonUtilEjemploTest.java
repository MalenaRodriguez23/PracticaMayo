import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class GsonUtilEjemploTest {
    @Test
    void testGuardarObjeto() {
        GsonUtilEjemplo.Usuario u = new GsonUtilEjemplo.Usuario("Ana", 30, "ana@test.com");
        GsonUtilEjemplo.guardarObjetoEnArchivo("usuario.json", u);
        File f = new File("usuario.json");
        assertTrue(f.exists());
    }
    @Test
    void testCargarObjeto() {
        GsonUtilEjemplo.Usuario u = new GsonUtilEjemplo.Usuario("Ana", 30, "ana@test.com");
        GsonUtilEjemplo.guardarObjetoEnArchivo("usuario.json", u);
        GsonUtilEjemplo.Usuario u2 = GsonUtilEjemplo.cargarObjetoDesdeArchivo("usuario.json", GsonUtilEjemplo.Usuario.class);
        assertNotNull(u2);
        assertEquals("Ana", u2.getNombre());
    }
    @Test
    void testMain() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GsonUtilEjemplo.main(new String[0]);

        System.setOut(originalOut);

        String salida = out.toString();
        assertTrue(salida.contains("Usuario cargado"));
    }
    @Test
    void testUsuarioGettersSettersYConstructor() {
        GsonUtilEjemplo.Usuario usuario = new GsonUtilEjemplo.Usuario("Carlos", 40, "carlos@test.com");

        assertEquals("Carlos", usuario.getNombre());
        assertEquals(40, usuario.getEdad());
        assertEquals("carlos@test.com", usuario.getCorreo());

        usuario.setNombre("Carlos Nuevo");
        usuario.setEdad(41);
        usuario.setCorreo("nuevo@test.com");

        assertEquals("Carlos Nuevo", usuario.getNombre());
        assertEquals(41, usuario.getEdad());
        assertEquals("nuevo@test.com", usuario.getCorreo());
    }
    @Test
    void testGuardarObjetoEnArchivoConExcepcion() {
        String rutaInvalida = "/carpeta/inexistente/archivo.json";
        GsonUtilEjemplo.Usuario usuario = new GsonUtilEjemplo.Usuario("Fallo", 0, "fallo@test.com");

        assertDoesNotThrow(() -> {
            GsonUtilEjemplo.guardarObjetoEnArchivo(rutaInvalida, usuario);
        });
    }
    @Test
    void testCargarObjetoDesdeArchivoConExcepcion() {
        String archivoInexistente = "no_existe.json";

        assertDoesNotThrow(() -> {
            GsonUtilEjemplo.Usuario resultado = GsonUtilEjemplo.cargarObjetoDesdeArchivo(archivoInexistente, GsonUtilEjemplo.Usuario.class);
            assertNull(resultado);
        });
    }

}