package Test;

public class GameTest {
    private Game game;
    private Jail jail;
    private Cube cube;
    private Board board;
    private Player player;

    @BeforeEach
    public void setUp() {
        jail = mock(Jail.class);
        cube = mock(Cube.class);
        board = mock(Board.class);
        player = mock(Player.class);
        List<Player> players = List.of(player);
        game = new Game(jail, cube, board, players);
    }

    @Test
    public void testSetUpWhenCalledThenGameInitializedWithMocks() {
        // Arrange
        Jail expectedJail = jail;
        Cube expectedCube = cube;
        Board expectedBoard = board;
        List<Player> expectedPlayers = List.of(player);

        // Act
        Jail actualJail = game.getJail();
        Cube actualCube = game.getCube();
        Board actualBoard = game.getBoard();
        List<Player> actualPlayers = game.getPlayers();

        // Assert
        assertEquals(expectedJail, actualJail, "The jail field in the game object should be the same as the jail mock object.");
        assertEquals(expectedCube, actualCube, "The cube field in the game object should be the same as the cube mock object.");
        assertEquals(expectedBoard, actualBoard, "The board field in the game object should be the same as the board mock object.");
        assertEquals(expectedPlayers, actualPlayers, "The players field in the game object should be a list containing the player mock object.");
    }
}