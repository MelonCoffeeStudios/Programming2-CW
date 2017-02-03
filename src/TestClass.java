import javax.swing.*;
import java.util.Scanner;

/**
 * Created by aarongriffin on 03/02/2017.
 */
public class TestClass {
    public void runTest(){

        /**
         * Declare new deck
         */
        Deck deck = new Deck();
        System.out.println("Created new deck! with " + deck.deck.size() + " cards\n\n");

        /**
         * Print out before shuffle to prove that each card is correctly set up
         */
        System.out.println(deck.toString());

        /**
         * Shuffle a lot
         */
        deck.shuffleDeck();
        System.out.println("Shuffling Deck! \n\n");

        /**
         * Print out results from shuffle
         */
        System.out.println(deck.toString());

        /**
         * Deal one card and print it out
         */
        System.out.println("Dealing one card and printing it! \n\n");
        System.out.println(deck.deal().toString());


        System.out.println("Deck size after deal: " + deck.toArrayList().size() + "\n\n");
        System.out.println("Resetting the deck and shuffling!\n\n");

        deck.newDeck();
        deck.shuffleDeck();

        System.out.println("Printing new deck");
        System.out.println(deck.toString());

        /**
         * Creating 4 new hands
         * Dealing 13 cards to each hand
         * This also tests the addCard method
         */
        HandList hands = new HandList();
        hands.dealToHands(deck, 13);

        /**
         * Printing hands to output
         */
        System.out.println(hands.toString());

        /**
         * Size of deck after dealing should be 0
         */
        System.out.println("Size of deck: " + deck.toArrayList().size());

        /**
         * Testing the counter Array
         */
        System.out.println("Printing hands counter");
        System.out.println("2,\t3,\t4,\t5,\t6,\t7,\t8,\t9,\t10,\tJ,\tQ,\tK,\tA");
        System.out.println(hands.get(0).getCounterString());

        /**
         * Testing the remove method using the different argument types
         */
        Card tmpCard = hands.get(0).hand.get(0);
        try {
            System.out.println("Attempting to remove card from Hand 1 (index 0) using Card argument");
            if(hands.get(0).remove(tmpCard)){
                System.out.println("Card Removed successfully!\n");
            }
        } catch (CardNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Attempting to remove card from Hand 1 (index 0) using index argument");
            if(hands.get(0).remove(3) != null) {
                System.out.println("4th Card (3rd index) removed successfully!\n");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        System.out.println("Attempting to remove all cards from Hand 2 (index 1)");
        try {
            if(hands.hands.get(0).remove(hands.get(1))){
                System.out.println("2nd Hand Successfully cleared!\n");
            }
        } catch (HandNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * Printing Size of hand 2 to prove its been cleared
         * Should be 0
         */
        System.out.println("Size of Hand 2 (index 1): " + hands.get(1).size());

        /**
         * Sort cards in Hand 1 in ascending order
         */
        hands.get(0).sortAscending();

        /**
         * Print out cards in Hand 1
         */
        System.out.println(hands.get(0).toString());

        /**
         * Sort cards in Hand 1 in descending order
         */
        hands.get(0).sortDescending();

        /**
         * Print out cards in Hand 1
         */
        System.out.println(hands.get(0).toString());

        /**
         * Print out number of Diamond Cards in Hand 3 (index 2)
         */
        System.out.println("Number of DIAMOND cards: " + hands.get(2).countSuit(Card.Suit.DIAMOND));

        /**
         * Print out number of 3's in hand 3
         */
        System.out.println("Number of THREE cards: " + hands.get(2).countRank(Card.Rank.THREE));

        /**
         * Test if cards are flush in hand 4 (index 3)
         */
        System.out.println("Are cards flush in hand 4: " + hands.get(3).isFlush());

        /**
         * Get difference
         */
        System.out.print("Ordinal difference between hand 1's 3rd card and hand 4's 3rd card: ");
        System.out.println(Card.difference(hands.get(0).hand.get(2), hands.get(3).hand.get(2)));

        /**
         * Get value difference
         */
        System.out.print("Value difference between hand 1's 3rd card and hand 4's 3rd card: ");
        System.out.println(Card.differenceValue(hands.get(0).hand.get(2), hands.get(3).hand.get(2)));
    }


}
