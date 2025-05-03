import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GsonEj1Test {
    @Test
    public void testMain() {
        GsonEj1.main(new String[]{});

        File archivoCirculo = new File("circles.json");
        File archivoEmpleado = new File("empleado.json");

        assertTrue(archivoCirculo.exists(), "El archivo circles.json debería existir");
        assertTrue(archivoEmpleado.exists(), "El archivo empleado.json debería existir");

        archivoCirculo.delete();
        archivoEmpleado.delete();
    }
}