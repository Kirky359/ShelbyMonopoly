package Cube;

import org.junit.Test;
import static org.junit.Assert.*;

public class СubeTest {
    @Test
    public void TestWorkOfCube(){
        Cube cube = new Cube();
        assertTrue(cube.rollCube()<=12 && cube.rollCube()>=2);
    }
}
