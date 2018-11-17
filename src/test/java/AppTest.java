/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import io.*;

public class AppTest {
    StubIO io;

    @Test public void appGreetsOnStart() {
        List<String> inputLines = new ArrayList<String>();
        inputLines.add("1");
        StubIO io = new StubIO(inputLines);
        App app = new App(io);
        app.run();
        assertEquals("Welcome to the CS literature recommendation system!", io.getPrints().get(0));
    }
    // @Test public void testAppHasAGreeting() {
    //     App classUnderTest = new App();
    //     assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    // }
}
