package com.company;

public class test {
    public static void main(String[] args) {

        Cards deck = new Cards(false);
        System.out.println("Before shuffle:");
        System.out.println(deck);
        long start = System.currentTimeMillis();
        deck.shuffle();
        long end = System.currentTimeMillis();
        System.out.println("After shuffle:");
        System.out.println(deck);
        System.out.println("Shuffle time in ms: " + (end - start));

    }
}
