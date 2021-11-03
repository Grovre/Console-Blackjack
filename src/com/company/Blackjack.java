/*package com.company;
import java.util.ArrayList;

public class Blackjack {

    // private Scanner input = new Scanner(System.in);
    private Deck deck = new Deck(false);

    private ArrayList<Integer> currentHand = new ArrayList<>();
    private ArrayList<Integer> houseHand = new ArrayList<>();

    public Blackjack() {
        deck.shuffle();
        // Initial deal
        currentHand = deck.dealCard(2, currentHand);
        houseHand = deck.dealCard(2, houseHand);
        System.out.println(currentHand);
        System.out.println(houseHand);

        showCards();
    }

    public void showCards() {
        System.out.println("Your hand:");
        for(int card : currentHand) {
            System.out.print(deck.trueCardValue(card) + deck.getSuit(card) + ", ");
        }
        System.out.println("\n");

        System.out.println("House: ");
        for(int card : houseHand) {
            
            System.out.print(deck.trueCardValue(card) + deck.getSuit(card) + ", ");
        }
    }

}
*/