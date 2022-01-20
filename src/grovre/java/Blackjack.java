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

    public void hit(Player p) {
        p.addToHand(deck.takeTopOfDeck());
    }

    public void firstCards() {
        for(Player p : players) {
            for(int i = 0; i < 2; i++) p.addToHand(deck.takeTopOfDeck());
        }
    }

}
