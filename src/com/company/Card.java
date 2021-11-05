package com.company;

public class Card {

    private int suit;
    private int value;
    private String suitString;
    private String valueString;

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
        valueString = valueString(cardValue);

        // checks cardSuit value in order to assign the string for proper card suit printing
        suitString = numToSuit(cardSuit);
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public String getValueString() {
        return valueString;
    }

    public String showCardSuit() {
        return suitString;
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
        this.suitString = numToSuit(suit);
    }

    public static String valueString(int value) {
        if(value > 10 || value == 1) {
            if(value == 11) {
                return "J";
            } else if(value == 12) {
                return "Q";
            } else if(value == 13) {
                return "K";
            } else if(value == 1) {
                return "A";
            }
        }
        return Integer.toString(value);
    }

    public void setValue(int value) {
        if(value > 10) {
            this.value = 10;
        } else {
            this.value = value;
        }
        this.valueString = valueString(value);
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suitString='" + suitString + '\'' +
                '}';
    }
}
