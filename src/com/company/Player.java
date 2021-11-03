package com.company;

import java.util.Arrays;

public class Player {

    private String name;
    private int bet;
    private int chips;
    private Card[] hand = new Card[11];
    private int cardsInHand = 0;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public void placeBet(int betAmount) {
        bet += betAmount;
    }

    public void callBet(int highestBet) {
        bet = highestBet;
    }

    public void addToHand(Card newCard) {
        hand[cardsInHand] = newCard;
        cardsInHand++;
    }

    public void removeFromHand(int deadCardIndex) {
        hand[deadCardIndex] = null;
        cardsInHand--;
    }

    public int getCardsInHand() {
        return cardsInHand;
    }

    public Card[] getHand() {
        return hand;
    }

    public void cleanToString() {
        StringBuilder str = new StringBuilder();
        for(Card card : hand) {
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
