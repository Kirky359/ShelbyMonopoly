package Board;

import Game.Player;

import java.util.LinkedList;
import java.util.Collections;
public class Deck {
    LinkedList<Card> deck = new LinkedList<>();
    public void takeCard(Player player){
        Card firstCard = deck.removeFirst();
        addCard(firstCard);
        firstCard.playCard(player);
    }
    public void addCard(Card card){
        deck.offer(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
}
