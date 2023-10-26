import Player.Player;

public class Card {
    String textCard;

    public Card(String message){
        this.textCard = message;
    }
    public void playCard(Player player){
        System.out.println("Player " + player.getName() + " got card: " + textCard);
    }
}
