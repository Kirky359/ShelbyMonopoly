import java.util.ArrayList;

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
}
