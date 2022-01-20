package grovre.java.players;

import grovre.java.Card;
import grovre.java.Deck;

public class Dealer extends Player {

    public Dealer() {
        super("House", 0);
    }

    public String getStartingHand() {
        return hand[0].toStringClean();
    }

    public void beginFlopping(Deck deck) {
        System.out.println("Dealer has: ");
        System.out.print(getHandClean());
        while(handTotal < 17) {
            flop(deck.takeTopOfDeck());
        }
        if(handTotal == 21) {
            setBlackjack(true);
        } else if(handTotal > 21) {
            setBust(true);
        }
    }

    private void flop(Card c) {
        addToHand(c);
        System.out.print(", " + c.toStringClean());
    }
}
