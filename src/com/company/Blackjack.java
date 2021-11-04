package com.company;

import java.util.Scanner;

public class Blackjack {

    private Player[] players = {new Player("John", 50), new Player("Jack", 50), new Player("Jill", 50)};
    private Deck deck = new Deck();
    private Scanner input = new Scanner(System.in);

    public Blackjack() {

        deck.shuffle();
        System.out.println("Dealing first cards...");
        for(Player player : players) {
            player.addToHand(deck.getTopOfDeck());
            player.addToHand(deck.getTopOfDeck());
            System.out.println(player.getName() + " received: " + player.getCardInHand(0) + ", " + player.getCardInHand(1));
        }

    }

    public void progress() {

        for(Player player : players) {
            System.out.println("\n\n");
            System.out.print(player.getName() + "'s cards: ");
            player.cleanCardsToString();
            System.out.println("Total: " + player.getHandTotal());
            if(player.getHandTotal() > 21) {
                System.out.println(player.getName() + " busted.");
                player.wentOut();
            } else if(player.getHandTotal() == 21) {
                System.out.println("Blackjack!");
            } else if(player.getCardInHand(0) == player.getCardInHand(1) && player.getCardInHand(3) == null){

            }

            /*boolean canSplit = false;
            for(Card cardToCheck : player.getHand()) {
                for(Card cardForChecking : player.getHand()) {
                    if(cardToCheck.getValue() == cardForChecking.getValue()) {
                        canSplit = true;
                    }
                }
            }*/

        }

    }

}