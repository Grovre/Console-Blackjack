package grovre.java;

import grovre.java.Card;

import java.util.Arrays;

public class Player {

    private final String name;
    private int bet;
    private int chips;
    private int amountOfCardsInHand = 0;
    private int handTotal = 0;
    private boolean isBust = false;
    private boolean hasBlackjack = false;
    private final Card[] hand = new Card[11];

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

    public boolean getBlackjack() {
        return hasBlackjack;
    }

    public void setBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public boolean getOut() {
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
    public void refreshHandTotal() {
        handTotal = 0;
        for (Card card : hand) {
            handTotal += card.getVALUE();
        }
    }

    // Finds the card at the index and returns the string of the card
    public String showCardAtHandIndex(int index) {
        String value = hand[index].getVALUE_SHOW();
        return value + hand[index].getSUIT_SHOW();
    }

    public void placeBet(int betAmount) {
        chips -= betAmount;
        bet += betAmount;
    }

    public void callBet(int highestBet) {
        chips -= highestBet - bet;
        bet = highestBet;
    }

    public void lostBet() {
        chips -= bet;
        bet = 0;
    }

    // Adds a card to the hand
    public void addToHand(Card newCard) {
        hand[amountOfCardsInHand] = newCard;
        amountOfCardsInHand++;
        if (newCard.getVALUE() > 10) {
            handTotal += 10;
        } else if (newCard.getVALUE() == 1 && handTotal + 11 <= 21) {
            handTotal += 11;
        } else {
            handTotal += newCard.getVALUE();
        }
    }

    // Used to remove a card from the hand
    public void removeFromHand(int deadCardIndex) {
        handTotal -= hand[deadCardIndex].getVALUE();
        hand[deadCardIndex] = null;
        amountOfCardsInHand--;
    }

    // Returns the total of all hands
    public int getHandTotal() {
        return handTotal;
    }

    public int getAmountOfCardsInHand() {
        return amountOfCardsInHand;
    }

    public Card[] getHand() {
        return hand;
    }

    public String showHandString() {
        StringBuilder str = new StringBuilder("" + hand[0].toStringClean());
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] == null) continue;
            str.append(", ").append(hand[i].toStringClean());
        }
        return str.toString();
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
