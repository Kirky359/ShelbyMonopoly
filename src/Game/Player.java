package Game;
import Board.*;
import Option.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player implements Cloneable {
    private String name;
    private int money;
    private int position;
    public boolean inJail;
    public int outOfJailCards;
    public int turnsInJail;
    private List<Property> properties;

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public Player(String name) {
        this.name = name;
        position = 0;
        money = 1500;
        inJail = false;
        outOfJailCards = 0;
        turnsInJail = 0;
        properties = new ArrayList<Property>();
    }
    private void sortPropertiesByGroup(List<Property> properties) {
        List<Utility> utilities = new ArrayList<>();
        List<RailRoad> railroads = new ArrayList<>();
        List<Property> sorted = new ArrayList<>();

        for (Property property : properties) {
            if (property instanceof Utility) {
                utilities.add((Utility) property);
            } else if (property instanceof RailRoad) {
                railroads.add((RailRoad) property);
            } else {
                sorted.add(property);
            }
        }
        Collections.sort(utilities);
        Collections.sort(railroads);
        Collections.sort(sorted);

        sorted.addAll(railroads);
        sorted.addAll(utilities);

        this.properties = sorted;
    }

    public void sell(Property property){
        addMoney(property.getPrice() / 2);
        property.setOwner(null);
    }

    public void addMoney(int addMoney){
        if(money < -addMoney){
            broke(-addMoney - money);
        }
        this.money += addMoney;
    }

    private void broke(int amountNeeded){
        System.out.println("You are missing $" + amountNeeded);
        List<PlayerOption> options = Arrays.asList(
                new MortgageOption(this)
        );
    }

    public void move(int numSquares, Board board){
        position += numSquares;
        //if pass GO
        if(position >= 40){
            System.out.println(name + " passed GO and collected $200");
            money += 200;
            position %= 40;
        }

        System.out.println("Landed on " + board.getCurrentSquare(this));
        board.getCurrentSquare(this).doAction(this);
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }

    public void buy(Property property){
        addMoney(-property.getPrice());
        properties.add(property);
        sortPropertiesByGroup(properties);
    }

    public void listProperties(){
        if(properties.isEmpty()){
            System.out.println("You do not own any properties");
        }
        for(Square property : properties){
            System.out.println(property);
        }
    }

    public boolean ownsGroup(PropertyColors.Group group){
        int count = 0;

        for(Property property : properties){
            if(property instanceof PropertyColors && ((PropertyColors) property).getGroup() == group){
                count++;
            }
        }

        return (count == group.maxInGroup);
    }

    public int getNumRailroads(){
        int numRailroads = 0;
        for(Property p : properties){
            if(p instanceof RailRoad){
                numRailroads++;
            }
        }

        return numRailroads;
    }

    public int getNumUtilities(){
        int numUtilities = 0;
        for(Property p : properties){
            if(p instanceof Utility){
                numUtilities++;
            }
        }

        return numUtilities;
    }

    public void mortgage(Property property){
        property.mortgaged = true;
        addMoney(property.getPrice() / 2);
    }

    public List<Property> getUnimprovedProperties(){
        List<Property> unimproved = new ArrayList<>();
        for(Property property : properties){
            if(property instanceof PropertyColors && ((PropertyColors) property).getNumHouses() != 0);
            else {
                unimproved.add(property);
            }
        }

        return unimproved;
    }

    public List<Property> getMortgagedProperties(){
        List<Property> mortgaged = new ArrayList<>();
        for(Property property : properties){
            if(property.mortgaged){
                mortgaged.add(property);
            }
        }

        return mortgaged;
    }

    public void payMortgage(Property property){
        double rate = 0.55;
        property.mortgaged = false;
        addMoney( (int) (-property.getPrice() * rate) );
    }

    public List<PropertyColors> getOwnColorGroupList(){
        List<PropertyColors> list = new ArrayList<>();
        for(Property property: properties){
            if(property instanceof PropertyColors && ownsGroup(((PropertyColors) property).getGroup())){
                list.add((PropertyColors) property);
            }
        }
        return list;
    }

    public List<PropertyColors> getHouseableProperties(){
        List<PropertyColors> houseable = new ArrayList<>();
        for(PropertyColors i : getOwnColorGroupList()){
            boolean lowestHouses = true;

            for(PropertyColors j : getOwnColorGroupList()){
                if(i.getGroup() == j.getGroup() && i.getNumHouses() > j.getNumHouses()){
                    lowestHouses = false;
                }
            }

            if(lowestHouses && i.getNumHouses() != 5){
                houseable.add(i);
            }
        }

        return houseable;
    }

    @Override
    public Player clone() {
        try {
            Player clonedPlayer = (Player) super.clone();
            clonedPlayer.properties = new ArrayList<>(properties.size());

            return clonedPlayer;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported for Player");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Player player = (Player) obj;
        return money == player.money &&
                position == player.position &&
                inJail == player.inJail &&
                outOfJailCards == player.outOfJailCards &&
                turnsInJail == player.turnsInJail &&
                Objects.equals(name, player.name) &&
                Objects.equals(properties, player.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, position, inJail, outOfJailCards, turnsInJail, properties);
    }
}
