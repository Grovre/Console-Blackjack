package com.company;

import javax.print.DocFlavor;

public class Card {

    private int suit;
    private int value;
    private String cardSuitString;

    /*
    Suit numbers
    1: Spades
    2: Clubs
    3: Hearts
    4: Diamonds

    Card values
    1: A
    2: 2
    3: 3
    ...
    10: 10
    11: Jack
    12: Queen
    13: King
     */

    // Card constructor, sets the card value and suit, along with a string for the suit to print what it is properly
    public Card(int cardValue, int cardSuit) {
        suit = cardSuit;
        value = cardValue;

        // checks cardSuit value in order to assign the string for proper card suit printing
        cardSuitString = numToSuit(cardSuit);
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public String getCardSuitString() {
        return cardSuitString;
    }

    public static String numToSuit(int cardSuit) {
        if(cardSuit == 1) {
            return "♠";
        } else if(cardSuit == 2) {
            return "♣";
        } else if(cardSuit == 3) {
            return "♥";
        } else if(cardSuit == 4) {
            return "♦";
        } else {
            return "J";
        }
    }

    public void setSuit(int suit) {
        this.suit = suit;
        this.cardSuitString = numToSuit(suit);
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", cardSuitString='" + cardSuitString + '\'' +
                '}';
    }
}
