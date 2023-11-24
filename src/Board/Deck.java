package Board;

import Game.Player;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> deck = new LinkedList<>();
    public void takeCard(Player player){
        Card firstCard = deck.remove(0);
        addCard(firstCard);
        firstCard.playCard(player);
    }
    public void addCard(Card card){
        deck.add(card);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    public List<Card> getDeck() {
        return deck;
    }
}
