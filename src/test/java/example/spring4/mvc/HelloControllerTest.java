package example.spring4.mvc;

import example.spring4.mvc.controller.HelloController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    @Test
    public void testIndex() {
        HelloController helloController = new HelloController();
        assertEquals("Hello Spring 4 mvc!", helloController.getIndex());
    }


}
