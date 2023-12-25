package Game;
import Board.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerMemento {
    private String name;
    private int money;
    private int position;
    private boolean inJail;
    private int outOfJailCards;
    private int turnsInJail;
    private List<Property> properties;

    public PlayerMemento(Player player) {
        this.name = player.getName();
        this.money = player.getMoney();
        this.position = player.getPosition();
        this.inJail = player.isInJail();
        this.outOfJailCards = player.getOutOfJailCards();
        this.turnsInJail = player.getTurnsInJail();
        this.properties = new ArrayList<>(player.listProperties());
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public boolean isInJail() {
        return inJail;
    }

    public int getOutOfJailCards() {
        return outOfJailCards;
    }

    public int getTurnsInJail() {
        return turnsInJail;
    }

    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }
}