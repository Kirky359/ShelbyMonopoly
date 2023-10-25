import java.util.LinkedList;
import java.util.Collections;
public class Deck {
    LinkedList<Card> deck = new LinkedList<>();

    public void takeCard(Player player){
        Card firstCard = deck.poll();
        deck.offer(firstCard);
        firstCard.playCard(player);
    }
    public void addCard(Card card){
        deck.offer(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
}
