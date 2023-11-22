package Game;
import Board.*;

import java.util.ArrayList;

import Board.Board;
import Board.Square;

public class Player {
    private String name;
    private int money;
    private int position;
    public boolean inJail;
    public int outOfJailCards;
    public int turnsInJail;
    private ArrayList<Square> properties;

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
        properties = new ArrayList<Square>();
    }


    private boolean owns(){
        return false;
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
}
