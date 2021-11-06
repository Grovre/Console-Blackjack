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

    // Show methods return a proper String instead of the primitive value (ex. 12 returns "Q" and 1 returns "A")

    // Card constructor, properly sets the card value and suit, along with a string for the suit to print what it is
    public Card(int cardValue, int cardSuit) {
        suit = cardSuit;
        value = cardValue;
        valueString = valueString(cardValue);

        // checks cardSuit value in order to assign the string for proper card suit printing
        suitString = numToSuit(cardSuit);
    }

    // Returns value (1-10)
    public int getValue() {
        return value;
    }

    // Returns suit (1-4)
    public int getSuit() {
        return suit;
    }

    // Returns value as String (ex. returns "A" if card was created with value 1)
    public String showValue() {
        return valueString;
    }

    // Returns suit as String (ex. returns spade symbol if card was created with suit 1)
    public String showCardSuit() {
        return suitString;
    }

    // Just returns the suit symbol from a suit number (1-4)
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

    // returns the String value of a card anywhere with a value from anything
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

    // Sets the value of the card, taking into account the valueString as well
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

    // Returns a clean string of the card
    public String cleanToString() {
        return valueString + suitString;
    }

}
