package grovre.java;

import grovre.java.players.Player;

public class Blackjack {

    private int playerCount;
    private Player[] players;
    private Deck deck = new Deck(true, true);

    public Card getTopCard() {
        return deck.takeTopOfDeck();
    }

}
