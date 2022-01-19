package grovre.java;

import grovre.java.players.Player;

public class Test {

    public static void main(String[] args) {
        Player p = new Player("Joseph", 2500);
        System.out.println(p.getChips());
        p.placeBet(2000);
        System.out.println(p.getBet());
        System.out.println(p.getChips());
        p.rewardBet(2);
        System.out.println(p.getChips());
    }

}
