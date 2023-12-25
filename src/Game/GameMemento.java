package Game;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {
    private final List<Player> players;
    private final int currentPlayerIndex;

    public GameMemento(List<Player> players, int currentPlayerIndex) {
        this.players = new ArrayList<>(players);
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}