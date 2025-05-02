import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class GsonSoloLecturaTest {
    @Test
    public void testGuardarObjetoEnArchivo() {
        String archivo = "test_guardado.json";
        GsonSoloLectura.Usuario usuario = new GsonSoloLectura.Usuario("Maria", 30, "maria@test.com");

        GsonSoloLectura.guardarObjetoEnArchivo(archivo, usuario);

        assertTrue(new File(archivo).exists());
        new File(archivo).delete();
    }

    @Test
    public void testGuardarObjetoConError() {
        String rutaInvalida = "/ruta/inexistente/archivo.json";
        GsonSoloLectura.Usuario usuario = new GsonSoloLectura.Usuario("Pedro", 25, "pedro@test.com");

        GsonSoloLectura.guardarObjetoEnArchivo(rutaInvalida, usuario);
    }

    @Test
    public void testCargarObjetoExitoso() {
        String archivo = "test_carga.json";
        GsonSoloLectura.Usuario usuarioOriginal = new GsonSoloLectura.Usuario("Carlos", 40, "carlos@test.com");
        GsonSoloLectura.guardarObjetoEnArchivo(archivo, usuarioOriginal);

        GsonSoloLectura.Usuario usuarioCargado = GsonSoloLectura.cargarObjetoDesdeArchivo(archivo, GsonSoloLectura.Usuario.class);

        assertNotNull(usuarioCargado);
        assertEquals("Carlos", usuarioCargado.getNombre());
        assertEquals(40, usuarioCargado.getEdad());

        new File(archivo).delete();
    }

    @Test
    public void testCargarObjetoConError() {
        GsonSoloLectura.Usuario usuario = GsonSoloLectura.cargarObjetoDesdeArchivo("no_existe.json", GsonSoloLectura.Usuario.class);

        assertNull(usuario);
    }

    @Test
    public void testMain() {
        String archivo = "usuario.json";
        GsonSoloLectura.Usuario usuario = new GsonSoloLectura.Usuario("MainTest", 99, "main@test.com");
        GsonSoloLectura.guardarObjetoEnArchivo(archivo, usuario);

        GsonSoloLectura.main(new String[]{});

        new File(archivo).delete();
    }

    @Test
    public void testUsuarioGettersSetters() {
        GsonSoloLectura.Usuario usuario = new GsonSoloLectura.Usuario("Luisa", 35, "luisa@test.com");

        assertEquals("Luisa", usuario.getNombre());
        assertEquals(35, usuario.getEdad());
        assertEquals("luisa@test.com", usuario.getCorreo());
        usuario.setNombre("Luisa Modificada");
        usuario.setEdad(36);
        usuario.setCorreo("behjv@gmail.com");

        assertEquals("Luisa Modificada", usuario.getNombre());
        assertEquals(36, usuario.getEdad());
        assertEquals("behjv@gmail.com", usuario.getCorreo());
    }
}
