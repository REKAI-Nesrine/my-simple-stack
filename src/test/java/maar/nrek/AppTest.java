package maar.nrek;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testMainMethodPrintsHelloWorld() {
        // Given - Capturer la sortie console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // When - Exécuter la méthode main
        App.main(new String[]{});

        // Then - Vérifier que "Hello World!" est affiché
        String output = outContent.toString().trim();
        assertEquals("Hello World!", output);

        // Restaurer System.out
        System.setOut(originalOut);
    }

    @Test
    public void testAppCanBeInstantiated() {
        // Given/When
        App app = new App();

        // Then
        assertNotNull(app);
    }
}
