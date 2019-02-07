package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    public void testGetHello() {
        //Controller cont = new Controller();
        assertNotEquals(Controller.getHello(), "hello");
        assertEquals(Controller.getHello(), "Hello");
    }

}