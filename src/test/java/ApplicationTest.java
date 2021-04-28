
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.snapgames.simplebuild.Application;

public class ApplicationTest {

    @Test
    public void testApplicationIsNotNull() {
        Application app = new Application();
        assertNotNull("The Application was not created", app);
    }

    @Test
    public void testRunArgs() {
        Application app = new Application();
        app.run(new String[] { "Test1", "Test2" });
        assertEquals("The first argument is wrong", "Test1", app.getArgs(0));
        assertEquals("The second argument is wrong", "Test2", app.getArgs(1));
    }

    @Test
    public void testRunArgsTitle() {
        Application app = new Application();
        app.run(new String[] { "Test1", "Test2" });
        assertEquals("Title is not the good one", "Default Application Title", app.getTitle());
        assertEquals("version is not the good one", "1.0.0", app.getVersion());
    }
}