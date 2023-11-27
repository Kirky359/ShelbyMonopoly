package Test;
import Board.*;
import Cube.*;
import Game.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    private Board board;
    private Jail jail;
    private Cube cube;
    private List<Player> players;


    void setUp() {
        // Создаем экземпляры Jail, Cube и List<Player> для использования в тестах
        jail = new Jail();
        cube = new Cube();
        players = new ArrayList<>();

        // Добавляем хотя бы одного игрока для тестирования
        players.add(new Player("Player1"));

        // Инициализируем доску перед каждым тестом
        board = new Board(jail, cube, players);
    }

    @Test
    void testGetSquareAt() {
        // Проверяем, что метод getSquareAt возвращает правильный квадрат для заданной позиции
        Square square = board.getSquareAt(0);
        assertEquals("GO", square.getName());

        square = board.getSquareAt(5);
        assertTrue(square instanceof RailRoad);
    }

    @Test
    void testGetCurrentSquare() {
        // Проверяем, что метод getCurrentSquare возвращает правильный квадрат для текущего игрока
        Player player = players.get(0);
        player.setPosition(3); // Перемещаем игрока на позицию 3

        Square square = board.getCurrentSquare(player);
        assertEquals("Baltic Avenue", square.getName());
    }

    // Добавьте другие тесты в соответствии с вашими требованиями
}

