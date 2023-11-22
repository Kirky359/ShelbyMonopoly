package Game;
public abstract class PlayerOption {
    String message;

    public PlayerOption(String message){
        this.message = message;
    }

    abstract public void action();

    public String toString(){
        return message;
    }
}
