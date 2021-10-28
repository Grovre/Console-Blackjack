package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

    // private Scanner input = new Scanner(System.in);
    private Cards deck = new Cards(false);

    private ArrayList<Integer> currentHand = new ArrayList<>();
    private ArrayList<Integer> houseHand = new ArrayList<>();

    public Blackjack() {
        deck.shuffle();
        // Initial deal
        currentHand = deck.dealCard(2, currentHand);
        houseHand = deck.dealCard(2, houseHand);
        System.out.println(currentHand);
        System.out.println(houseHand);
    }

}
