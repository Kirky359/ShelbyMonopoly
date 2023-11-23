package Board;
import Game.Player;

import java.util.List;

public abstract class Card {
    String textCard;

    public Card(String message){
        this.textCard = message;
    }
    public void playCard(Player player){
        doAction(player);
        System.out.println("Player " + player.getName() + " got card: " + textCard);
    }

    public abstract void doAction(Player player);
}
class CollectCard extends Card {
    protected Integer amount;

    public CollectCard(int amount, String text){
        super(createCollectMessage(amount, text));
        this.amount = amount;
    }

    protected static String createCollectMessage(int amount, String text){
        String collectMessage = text + ". Collect $" + amount;
        String payMessage = text + ". Pay $" + -amount;
        return (amount > 0) ? collectMessage : payMessage;
    }

    public void doAction(Player player){
        player.addMoney(amount);
    }
}
class CollectEveryCard extends CollectCard {
    private List<Player> players;

    public CollectEveryCard(List<Player> players, int amount, String text){
        super(amount, createCollectMessage(amount, text));
        this.players = players;
    }

    protected static String createCollectMessage(int amount, String text){
        return CollectCard.createCollectMessage(amount, text) + ((amount > 0) ? " from every player" : " to every player");
    }

    public void doAction(Player player){
        player.addMoney(amount * players.size());

        for(Player p : players){
            p.addMoney(-amount);
        }
    }
}
class HouseRepairCard extends CollectCard {
    private int perHouse;
    private int perHotel;

    public HouseRepairCard(int perHouse, int perHotel, String text){
        super(0, text);
        this.perHouse = perHouse;
        this.perHotel = perHotel;
    }

    private int calculateFee(Player player){
        int fee = 0;

        for(PropertyColors p : player.getOwnColorGroupList()){
            if(p.getNumHouses() == 5){
                fee += perHotel;
            } else if (p.getNumHouses() > 0) {
                fee += perHouse * p.getNumHouses();
            }
        }

        amount = fee;
        return fee;
    }

    public void doAction(Player player){
        player.addMoney(-calculateFee(player));
    }
}

class MoveToCard extends Card {
    private int[] index;
    private Board board;

    public MoveToCard(int[] index, Board board, String text){
        super(text);
        this.index = index;
        this.board = board;
    }

    public void doAction(Player player){
        int minimumDistance = 40;

        for(int i = 0; i < index.length; i++){
            int distanceToIndex = (40 + index[i] - player.getPosition()) % 40;
            if ((40 + index[i] - player.getPosition()) < minimumDistance) {
                minimumDistance = distanceToIndex;
            }
        }

        player.move(minimumDistance, board);
    }
}

class MoveCard extends Card {
    private int numSquares;
    private Board board;

    public MoveCard(int numSquares, Board board, String text){
        super(text);
        this.numSquares = numSquares;
        this.board = board;
    }

    public void doAction(Player player){
        player.move(numSquares, board);
    }
}
class OutOfJailCard extends Card {
    public OutOfJailCard(){
        super("Get Out Of Jail For Free");
    }
    public void doAction(Player player) {
        player.outOfJailCards++;
    }
}
class ToJailCard extends Card{
    private Jail jail;

    public ToJailCard(Jail jail){
        super("Go Directly To Jail");
        this.jail = jail;
    }

    public void doAction(Player player){
        jail.sendPlayerToJail(player);
    }
}


