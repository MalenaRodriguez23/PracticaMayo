import com.google.gson.Gson;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GsonAlumnoTest {

    @org.junit.jupiter.api.Test
    public void testArgumentosIncorrectos() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        GsonAlumno.main(new String[]{"init"});

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Error: El argumento del archivo no es correcto"),
                "El mensaje de error debe coincidir exactamente");
    }

    @org.junit.jupiter.api.Test
    public void testSinArgumentos() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        GsonAlumno.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Error: El argumento del archivo no es correcto"));
        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    public void testOperacionInit() {
        String testFile = "test_init.json";
        GsonAlumno.main(new String[]{"init", testFile});

        assertTrue(new File(testFile).exists());
        new File(testFile).delete();
    }

    @org.junit.jupiter.api.Test
    public void testOperacionShow() {
        String testFile = "test_show.json";
        GsonAlumno.main(new String[]{"init", testFile});

        GsonAlumno.main(new String[]{"show", testFile});

        new File(testFile).delete();
    }

    @org.junit.jupiter.api.Test
    public void testOperacionNoReconocida() {
        GsonAlumno.main(new String[]{"invalid", "bhcdi.txt"});
    }

    @org.junit.jupiter.api.Test
    public void testErrorIO() {
        GsonAlumno.main(new String[]{"show", "/ruta/inexistente/archivo.txt"});
    }
}
