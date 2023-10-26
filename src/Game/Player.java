package Player;

import java.util.ArrayList;
import Square.Square

public class Player {
    private String name;
    private int money;
    private int position;
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
    public void move(int numSquares){
        position += numSquares;
        //if pass GO
        if(position >= 40){
            System.out.println(name + " passed GO and collected $200");
            money += 200;
            position %= 40;
        }
    }
    public void showProperties(){
        if(properties.isEmpty()){
            System.out.println("Player.Player do not own any properties");
        }
        for(Square property : properties){
            System.out.println(property);
        }
    }
}
