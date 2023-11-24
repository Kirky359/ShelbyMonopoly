package Cube;

public class CubeTest {

    @Test
    public void testRollCubeWhenCalledThenReturnsValueWithinRange() {
        // Arrange
        Cube cube = new Cube();

        // Act
        int result = cube.rollCube();

        // Assert
        assertTrue(result >= 2 && result <= 12, "The result should be within the range 2 to 12");
    }

    @Test
    public void testRollCubeWhenCalledTwiceThenReturnsDifferentValues() {
        // Arrange
        Cube cube = new Cube();

        // Act
        int result1 = cube.rollCube();
        int result2 = cube.rollCube();

        // Assert
        assertNotEquals(result1, result2, "The results of two consecutive rolls should be different");
    }
}