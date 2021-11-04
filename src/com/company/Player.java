package com.company;

import java.util.Arrays;

public class Player {

    private String name;
    private int bet;
    private int chips;
    private Card[] hand = new Card[52];
    private int amountOfCardsInHand = 0;
    private int handTotal = 0;
    private boolean isOut = false;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public String getName() {
        return name;
    }

    // Sets the player boolean isOut to true
    public void wentOut() {
        isOut = true;
    }

    // Returns whether the player is out of the game or not
    public boolean isOut() {
        return isOut;
    }

    // Refreshes handTotal by counting all the cards in the player's hand again
    public void refreshHandTotal() {
        handTotal = 0;
        for( Card card : hand) {
            handTotal += card.getValue();
        }
    }

    // Finds the card at the index and returns the
    public String getCardInHand(int index) {
        return hand[index].getValue() + hand[index].getCardSuitString();
    }

    public void placeBet(int betAmount) {
        bet += betAmount;
    }

    public void callBet(int highestBet) {
        bet = highestBet;
    }

    // Adds a card to the hand
    public void addToHand(Card newCard) {
        hand[amountOfCardsInHand] = newCard;
        amountOfCardsInHand++;
        handTotal += newCard.getValue();
    }

    // Used to remove a card from the hand
    public void removeFromHand(int deadCardIndex) {
        handTotal -= hand[deadCardIndex].getValue();
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

    public void cleanCardsToString() {
        StringBuilder str = new StringBuilder();
        for(Card card : hand) {
            if(card == null) {
                continue;
            }
            str.append(card.getValue()).append(card.getCardSuitString()).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        System.out.println(str);
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
