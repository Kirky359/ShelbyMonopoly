package Game;
import Board.*;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int position;
    public boolean inJail;
    public int outOfJailCards;
    public int turnsInJail;
    private ArrayList<Property> properties;

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public Player(String name){
        this.name = name;
        position = 0;
        money = 1500;
        inJail = false;
        outOfJailCards = 0;
        turnsInJail = 0;
        properties = new ArrayList<Property>();
    }


    private boolean owns(Property property){
        return properties.contains(property);
    }

    private void buy(){
    }
    public void addMoney(int addMoney){
        this.money += addMoney;
    }
    public void move(int numSquares, Board board){
        position += numSquares;
        //if pass GO
        if(position >= 40){
            System.out.println(name + " passed GO and collected $200");
            money += 200;
            position %= 40;
        }
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }

    public void buy(Property property){
        addMoney(-property.getPrice());
        properties.add(property);
    }
    public void showProperties(){
        if(properties.isEmpty()){
            System.out.println("Game.Player do not own any properties");
        }
        for(Square property : properties){
            System.out.println(property);
        }
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
    public ArrayList<Property> getUnimprovedProperties(){
        ArrayList<Property> unimproved = new ArrayList<>();
        for(Property property : properties){
            if(property instanceof PropertyColors && ((PropertyColors) property).getNumHouses() != 0);
            else {
                unimproved.add(property);
            }
        }

        return unimproved;
    }

    public ArrayList<Property> getMortgagedProperties(){
        ArrayList<Property> mortgaged = new ArrayList<>();
        for(Property property : properties){
            if(property.mortgaged){
                mortgaged.add(property);
            }
        }

        return mortgaged;
    }

    public void payMortgage(Property property){
        property.mortgaged = false;
        addMoney( (int) (-property.getPrice() * 0.55) );
    }

    public ArrayList<PropertyColors> getOwnColorGroupList(){
        ArrayList<PropertyColors> list = new ArrayList<>();
        for(Property property: properties){
            if(property instanceof PropertyColors && ownsGroup(((PropertyColors) property).getGroup())){
                list.add((PropertyColors) property);
            }
        }
        return list;
    }
    public ArrayList<PropertyColors> getHouseableProperties(){
        ArrayList<PropertyColors> houseable = new ArrayList<>();
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
}
