public class Player {

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    private String name;
    private int money;
    private int position;

    public Player(String name){
        this.name = name;
    }

    private boolean owns(){
        return false;
    }

    private void buy(){

    }
}
