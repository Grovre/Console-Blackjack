package grovre.java.players;

import grovre.java.Card;
import grovre.java.Deck;

import java.util.Arrays;

public class Player {

    private final String name;
    private int bet;
    private int chips;
    protected int amountOfCardsInHand = 0;
    protected int handTotal = 0;
    protected boolean isBust = false;
    protected boolean hasBlackjack = false;
    protected final Card[] hand = new Card[11];
    protected boolean hasAce;
    private boolean canSplit;
    private boolean canDoubleDown;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public int getBet() {
        return bet;
    }

    public int getChips() {
        return chips;
    }

    public void rewardBet(int multiplier) {
        chips += bet * multiplier;
    }

    public String getName() {
        return name;
    }

    public boolean hasBlackjack() {
        return hasBlackjack;
    }

    public void setBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public boolean isOut() {
        return isBust;
    }

    // Sets the player boolean isBust to true
    public void setOut(boolean isBust) {
        this.isBust = isBust;
    }

    // Returns whether the player is out of the game or not
    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean isBust) {
        this.isBust = isBust;
    }

    // Refreshes handTotal by counting all the cards in the player's hand again
    public int refreshHandTotal() {
        handTotal = 0;
        for (Card card : hand) {
            if(card == null) break;
            handTotal += card.getVALUE();
        }
        return handTotal;
    }

    public void resetHand() {
        Arrays.fill(hand, null);
        amountOfCardsInHand = 0;
        handTotal = 0;
        isBust = false;
        hasBlackjack = false;
    }

    // Finds the card at the index and returns the string of the card
    public String showCardAtHandIndex(int index) {
        String value = hand[index].getVALUE_SHOW();
        return value + hand[index].getSUIT_SHOW();
    }

    public int placeBet(int betAmount) {
        chips -= betAmount;
        bet += betAmount;
        return bet;
    }

    public void callBet(int highestBet) {
        chips -= highestBet - bet;
        bet = highestBet;
    }

    public void lostBet() {
        bet = 0;
    }

    // Adds a card to the hand
    public void addToHand(Card newCard) {
        if(amountOfCardsInHand >= 11) {
            System.out.println("Cannot add anymore cards to hand. " +
                    "This is for the program's safety. " +
                    "If this is causing an error with the functionality of the game, please make an issue on github.");
            return;
        }
        hand[amountOfCardsInHand] = newCard;
        amountOfCardsInHand++;
        handTotal += newCard.getVALUE();
        if(handTotal > 21 && hasAce) {
            for(Card c : hand) {
                if(c.getCardType() == 1) {
                    c.setVALUE(1);
                    if(refreshHandTotal() <= 21) break;
                }
            }
            System.out.println("No Ace found. Why did the search start?");
            System.out.println("Hand: " + Deck.toStringClean(hand));
        }
    }

    public boolean updateBlackjack() {
        if(handTotal == 21) {
            hasBlackjack = true;
        } else {
            hasBlackjack = false;
        }
        return hasBlackjack;
    }

    public Card getRecentCard() {
        return hand[amountOfCardsInHand - 1];
    }

    // Used to remove a card from the hand
    // !!! Recommended not to use, can break other methods currently!!!
    public Card removeFromHand(int deadCardIndex) {
        Card card = hand[deadCardIndex];
        handTotal -= hand[deadCardIndex].getVALUE();
        hand[deadCardIndex] = null;
        amountOfCardsInHand--;
        return card;
    }

    // Returns the total of all hands
    public int getHandTotal() {
        refreshHandTotal();
        return handTotal;
    }

    public int getAmountOfCardsInHand() {
        return amountOfCardsInHand;
    }

    public Card[] getHand() {
        return hand;
    }

    public String toStringClean() {
        StringBuilder str = new StringBuilder("" + hand[0].toStringClean());
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] == null) continue;
            str.append(", ").append(hand[i].toStringClean());
        }
        return str.toString();
    }

    public String getCurrentHand() {
        return toStringClean();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", bet=" + bet +
                ", chips=" + chips +
                ", hand=" + Arrays.toString(hand) +
                '}';
    }
}
