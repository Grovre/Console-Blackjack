package grovre.java;

import java.util.Scanner;

public class Blackjack {

    private final Player dealer = new Player("House", -1);
    private Player[] players = new Player[7];
    private Deck deck = new Deck();
    private Scanner input = new Scanner(System.in);
    private int betMultiplier = 2;

    public Blackjack() {

        // Initialization of game
        System.out.println("How many chips will everyone be starting with?");
        int chipCount = input.nextInt();
        System.out.println("How many players are playing?");
        int playerCount = input.nextInt();

        // Creates a player for every player playing
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player name: ");
            String name = input.next();
            System.out.println("How many chips would you like to bet, " + name + "?");
            players[i] = new Player(name, chipCount);
            players[i].placeBet(input.nextInt());
        }

        // Shuffle (doh)
        deck.shuffleDeck();

        // House gets cards first
        dealer.addToHand(deck.getTopOfDeck());
        dealer.addToHand(deck.getTopOfDeck());
        System.out.println("Dealer gets card: " + dealer.showCardAtHandIndex(0));
        System.out.println("Dealer gets card: Unknown");

        // Deals 2 cards to each player
        System.out.println("\nDealing first cards...");
        for (Player player : players) {
            // if player == null: continue just makes sure no errors occur and no unreal players play
            if (player == null) {
                continue;
            }
            player.addToHand(deck.getTopOfDeck());
            player.addToHand(deck.getTopOfDeck());
            System.out.println(player.getName() + " received: " + player.showCardAtHandIndex(0) + ", " + player.showCardAtHandIndex(1));
        }

    }

    // Probably never used
    public Deck getDeck() {
        return deck;
    }

    // Gamer time
    public void progress() {

        boolean isPlaying = true;
        while (isPlaying) {

            for (Player player : players) {
                if (player == null) {
                    continue;
                }

                player.setBlackjack(false);
                player.setOut(false);
                System.out.println("\n");
                if (player.getHandTotal() > 21) {
                    System.out.println(player.getName() + " busted.");
                    player.setOut(true);
                } else if (player.getHandTotal() == 21) {
                    System.out.println("Blackjack!");
                    player.setBlackjack(true);
                }

                // Checks if a player has their hasBlackjack status set to true, then it skips to the next person if true
                if (player.getBlackjack()) {
                    continue;
                }

                // Hit or pass
                boolean ongoingTurn = true;
                System.out.println("\n\n" + player.getName() + "'s turn");
                while (ongoingTurn) {
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

                    // Blackjack trigger
                    if (player.getHandTotal() == 21) {
                        System.out.println(player.getName() + " has a blackjack!");
                        ongoingTurn = false;
                        player.setBlackjack(true);
                    } else if (player.getHandTotal() > 21) {
                        System.out.println("Busted.");
                        ongoingTurn = false;
                        player.setOut(true);
                    }

                }

                System.out.println(player.getName() + "'s closing hand: " + player.showHandString());
                System.out.println("Closing hand's total: " + player.getHandTotal());

            }

            System.out.println("Dealer's turn.");
            System.out.println("Dealer has: " + dealer.showHandString());
            // Stand on soft 17
            while (dealer.getHandTotal() < 17) {
                System.out.println("Total: " + dealer.getHandTotal());
                System.out.print("Dealer hits: ");
                Card newCard = deck.getTopOfDeck();
                dealer.addToHand(newCard);
                System.out.println(newCard.toStringClean());
            }

            if (dealer.getHandTotal() == 21) {
                System.out.println("Dealer has a blackjack. A pity.");
                dealer.setBlackjack(true);
            } else if (dealer.getHandTotal() > 21) {
                System.out.println("Dealer went bust. Everybody wins.");
                dealer.setOut(true);
            } else {
                System.out.println("Dealer finishes with " + dealer.getHandTotal());
            }

            System.out.println();
            for (Player player : players) {
                if (player == null) {
                    continue;
                }

                // If player and dealer have a blackjack, are out, or have the same hand total, give bet back
                if ((player.getBlackjack() == dealer.getBlackjack()) || (dealer.getOut() == player.getOut()) || (dealer.getHandTotal() == player.getHandTotal())) {
                    player.rewardBet(1);
                    System.out.println(player.getName() + " received their chips back.");
                } else if (player.getHandTotal() > dealer.getHandTotal()) {
                    player.rewardBet(betMultiplier);
                    System.out.println(player.getName() + " won " + (player.getBet() * 2) + " chips!");
                } else {
                    System.out.println(player.getName() + " lost!");
                }

                isPlaying = false;

            }

        }

    }
}
