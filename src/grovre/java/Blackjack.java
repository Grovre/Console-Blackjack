package grovre.java;

import grovre.java.players.Dealer;
import grovre.java.players.Player;

import java.util.Scanner;

public class Blackjack {

    private int playerCount;
    private Player[] players;
    private final Dealer dealer;
    private final Deck deck;

    public Blackjack(Player[] players) {
        this.players = players;
        dealer = new Dealer();
        deck = new Deck(true,true);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Card getTopCard() {
        return deck.takeTopOfDeck();
    }

    public void takeBets() {
        int pot = 0;
        for(Player p : players) {
            System.out.println(p.getName() + ", how much are you betting?");
            p.placeBet(new Scanner(System.in).nextInt());
            pot += p.getBet();
        }
        System.out.println("Total pot: " + pot);
    }

    public void playerActions(Player p) {
        String name = p.getName();
        p.refreshBooleans();
        if(p.isBust()) {
            System.out.println(name + " went bust.");
        }
        if(p.hasBlackjack()) {
            System.out.println(name + " has a blackjack.");
        }
        if(p.isStanding()) {
            System.out.println(name + " stands.");
        }

        System.out.print("Do you want to hit (1) or stand (2)");
        if(p.canSplit()) System.out.print(" or split (3)");
        if(p.canDoubleDown()) System.out.print(" or double down (4)");
        System.out.print("?");

        int choice = new Scanner(System.in).nextInt();
        if(choice == 1) {
            p.addToHand(deck.takeTopOfDeck());
            System.out.println(p.getHandClean());
            p.canSplit(true);
            p.canDoubleDown(false);
            playerActions(p);
        } else if(choice == 2) {
            p.setStanding(true);
        } else if(choice == 3) {
            // need to implement splits and removing cards from hands
        } else if(choice == 4) {
            p.placeBet(p.getBet());
            p.addToHand(deck.takeTopOfDeck());
            p.setStanding(true);
        }
    }

    public void firstCards() {
        for(Player p : players) {
            for(int i = 0; i < 2; i++) p.addToHand(deck.takeTopOfDeck());
        }
    }

}
