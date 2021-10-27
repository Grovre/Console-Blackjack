package com.company;
import java.util.Arrays;

public class Cards {

    /*
    1 = A
    2 = 2
    3 = 3
    ...
    10 = 10
    11 = J
    12 = Q
    13 = K
     */

    private int[] spades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] clovers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    
    /*private int[] spadesWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] cloversWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] heartsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] diamondsWithJoker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};*/

    private final String spade = "♠";
    private final String clover = "♣";
    private final String heart = "♥";
    private final String diamond = "♦";

    public Cards(boolean hasJoker) {

        if(hasJoker) {
            spades = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            clovers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            hearts = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            diamonds = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        }

    }

    @Override
    public String toString() {
        return "Cards{" +
                "spades=" + Arrays.toString(spades) +
                ", clovers=" + Arrays.toString(clovers) +
                ", hearts=" + Arrays.toString(hearts) +
                ", diamonds=" + Arrays.toString(diamonds) +
                '}';
    }

    public void shuffleAll() {
        spades = shuffle(spades);
        clovers = shuffle(clovers);
        hearts = shuffle(hearts);
        diamonds = shuffle(diamonds);
    }

    public int[] shuffle(int[] suit) {
        int[] temp = new int[suit.length]; // Temporary array for shuffling
        for(int i = 0; i < suit.length; i++) { // Loops through all spades 1-13 (or 1-14 if joker) to put it into a random index in the temp array
            int pushIndex = (int) (Math.random() * suit.length); // turns pushIndex into a random number 1-13 (or 14)
            if(temp[pushIndex] != 0) { // Checks if temp array index is empty
                i--;
                continue;
            }
            temp[pushIndex] = i+1; // Pushes i into temp at pushIndex
        }
        return temp;
    }

    public int[] getSpades() {
        return spades;
    }

    public int[] getHearts() {
        return hearts;
    }

    public int[] getDiamonds() {
        return diamonds;
    }

    public int[] getClovers() {
        return clovers;
    }

    public void setSpades(int[] newSuit) {
        spades = newSuit;
    }

    public void setDiamonds(int[] newSuit) {
        diamonds = newSuit;
    }

    public void setHearts(int[] newSuit) {
        hearts = newSuit;
    }

    public void setClovers(int[] newSuit) {
        clovers = newSuit;
    }

}
