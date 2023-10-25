import java.util.LinkedList;
import java.util.Collections;
public class Deck {
    LinkedList<String> deck = new LinkedList<>();

    public void takeCard(Player player){
        String firstCard = deck.poll();
        deck.offer(firstCard);
    }
    public void addCard(String card){
        deck.offer(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
}
