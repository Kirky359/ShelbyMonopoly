import java.util.ArrayList;

public class Board {
    private Square[] field = new Square[40];
    public ArrayList<Player> players;
    //тут має бути кубик, чекаю на реалізацію


    public Board(ArrayList<Player> players){
        this.players = players;

        for(int i = 0; i < 40; i++){
            field[i] = new Square();
        }
    }

    public Square getSquare(int index){
        return field[index];
    }

    public Square getCurrentSquare(Player player){
        return field[player.getPosition()];
    }
}
