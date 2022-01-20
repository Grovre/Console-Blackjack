package grovre.java;

import grovre.java.players.Player;

public class Test {

    public static void main(String[] args) {
        Player p = new Player("Joseph", 2500);
        Deck d = new Deck(true, true);

        Player[] players = {new Player("Jack", 450), new Player("Jill", 1279)};
        Blackjack b = new Blackjack(players);
        b.takeBets();
    }

}
