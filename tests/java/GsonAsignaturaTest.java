import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GsonAsignaturaTest {

    @Test
    void main() {
        GsonAsignatura.main(new String[]{});

        File archivo = new File("asignatura.json");
        assertTrue(archivo.exists(), "El archivo debería existir");

        archivo.delete();
    }
}