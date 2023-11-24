package Test;

import Cube.Cube;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CubeTest {
    private Cube cube;

    @BeforeEach
    public void setup() {
        cube = new Cube();
    }

    @Test
    public void testRollCube() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = cube.rollCube();
        Assertions.assertTrue(result >= 2 && result <= 12);
    }

    @Test
    public void testIsDouble() {
        cube.setRoll1(3);
        cube.setRoll2(3);
        Assertions.assertTrue(cube.isDouble());

        cube.setRoll1(4);
        cube.setRoll2(2);
        Assertions.assertFalse(cube.isDouble());
    }

    @Test
    public void testActualRoll() {
        cube.setRoll1(2);
        cube.setRoll2(4);
        int result = cube.actualRoll();
        Assertions.assertEquals(6, result);
    }

    // Add more tests for other methods in the Cube class

}
