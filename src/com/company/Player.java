package com.company;

import java.util.Arrays;

public class Player {

    private String name;
    private int bet;
    private int chips;
    private Card[] hand = new Card[52];
    private int amountOfCardsInHand = 0;
    private int handTotal = 0;
    private boolean isBust = false;
    private boolean hasBlackjack = false;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public String getName() {
        return name;
    }

    // Sets the player boolean isBust to true
    public void setOut(boolean isBust) {
        this.isBust = true;
    }

    public void setBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public boolean getBlackjack() {
        return hasBlackjack;
    }

    public boolean getOut() {
        return isBust;
    }

    // Returns whether the player is out of the game or not
    public boolean isBust() {
        return isBust;
    }

    // Refreshes handTotal by counting all the cards in the player's hand again
    public void refreshHandTotal() {
        handTotal = 0;
        for( Card card : hand) {
            handTotal += card.getValue();
        }
    }

    // Finds the card at the index and returns the string of the card
    public String showCardAtHandIndex(int index) {
        int cardValue = hand[index].getValue();
        String value = "";
        if(cardValue > 10 || cardValue == 1) {
            if(cardValue == 11) {
                value = "J";
            } else if(cardValue == 12) {
                value = "Q";
            } else if(cardValue == 13) {
                value = "K";
            } else if(cardValue == 1) {
                value = "A";
            }
        } else {
            value = Integer.toString(cardValue);
        }
        return value + hand[index].showCardSuit();
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
        if(newCard.getValue() > 10) {
            handTotal += 10;
        } else if(newCard.getValue() == 1 && handTotal + 11 <= 21) {
            handTotal += 11;
        } else {
            handTotal += newCard.getValue();
        }
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

    public String showHandString() {
        StringBuilder str = new StringBuilder();
        for(Card card : hand) {
            if(card == null) {
                continue;
            }
            str.append(card.getValueString()).append(card.showCardSuit()).append(", ");
        }
        return str.substring(0, str.length() - 2);
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
