package com.company;

import java.util.Scanner;

public class Blackjack {

    private Player[] players = new Player[7];
    private Deck deck = new Deck();
    private Scanner input = new Scanner(System.in);

    public Blackjack() {

        System.out.println("How many chips will everyone be starting with?");
        int chipCount = input.nextInt();
        System.out.println("How many players are playing?");
        int playerCount = input.nextInt();

        for(int i = 0; i < playerCount; i++) {
            System.out.println("Player name: ");
            String name = input.next();
            players[i] = new Player(name, chipCount);
        }

        deck.shuffle();
        System.out.println("Dealing first cards...");
        for(Player player : players) {
            if(player == null) {
                continue;
            }
            player.addToHand(deck.getTopOfDeck());
            player.addToHand(deck.getTopOfDeck());
            System.out.println(player.getName() + " received: " + player.showCardAtHandIndex(0) + ", " + player.showCardAtHandIndex(1));
        }

    }

    public Deck getDeck() {
        return deck;
    }

    public void progress() {

        for(Player player : players) {
            if(player == null) {
                continue;
            }
            System.out.println("\n");
            if(player.getHandTotal() > 21) {
                System.out.println(player.getName() + " busted.");
                player.setOut(true);
            } else if(player.getHandTotal() == 21) {
                System.out.println("Blackjack!");
                player.setBlackjack(true);
            } /*else if(player.getCardInHand(0) == player.getCardInHand(1) && player.getCardInHand(3) == null){
                split(player);
            }*/

            // Checks if a player has their hasBlackjack status set to true, and if they do then it skips to the next person
            if(player.getBlackjack()) {
                continue;
            }

            boolean ongoingTurn = true;
            System.out.println("\n\n\n\n\n\n\n\n\n\n" + player.getName() + "'s turn");
            while(ongoingTurn) {
                System.out.println("Current hand: " + player.showHandString());
                System.out.println("Hand Total: " + player.getHandTotal());
                System.out.println("Hit (1) or pass (2)?");
                int hitOrPass = input.nextInt();
                if (hitOrPass == 1) {
                    player.addToHand(deck.getTopOfDeck());
                    System.out.println("\nNew card: " + player.showCardAtHandIndex(2));
                } else if (hitOrPass == 2) {
                    System.out.println("Passed.");
                    ongoingTurn = false;
                }

                if(player.getHandTotal() == 21) {
                    System.out.println("Blackjack!");
                    ongoingTurn = false;
                } else if(player.getHandTotal() > 21) {
                    System.out.println("Busted.");
                    ongoingTurn = false;
                }

                

            }

            System.out.println(player.getName() + "'s closing hand: " + player.showHandString());
            System.out.println("Closing hand's total: " + player.getHandTotal());

        }

    }

}