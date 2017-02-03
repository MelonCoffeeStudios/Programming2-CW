/**
 * Created by aarongriffin on 10/01/2017.
 */
import java.io.Serializable;
import java.util.Comparator;

public class Card implements Serializable, Comparable<Card>{
    public static final long serialVersionUID = 100;


    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        private int rankValue;
        private static Rank[] rankArray = values();

        static {
            TWO.rankValue = 2;
            THREE.rankValue = 3;
            FOUR.rankValue = 4;
            FIVE.rankValue = 5;
            SIX.rankValue = 6;
            SEVEN.rankValue = 7;
            EIGHT.rankValue = 8;
            NINE.rankValue = 9;
            TEN.rankValue = 10;
            JACK.rankValue = 10;
            QUEEN.rankValue = 10;
            KING.rankValue = 10;
            ACE.rankValue = 11;
        }

        public Rank getNext(){
            return this.rankArray[(this.ordinal()+1) % this.rankArray.length];
        }

        public int getRankValue() {
            return this.rankValue;
        }
    }

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE
    }


    private Rank rank;
    private Suit suit;


    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public static int difference(Card c, Card c2){
        return (c2.rank.ordinal()+1) - (c.rank.ordinal() + 1);
    }

    public static int differenceValue(Card c, Card c2){
        return c.rank.rankValue - c2.rank.rankValue;
    }


    public static class CompareDescending implements Comparator<Card> {

        @Override
        public int compare (Card c, Card c2) {
            int val = -1 * c.compareTo(c2);

            return val;
        }
    }

    public static class CompareSuit implements Comparator<Card> {

        @Override
        public int compare (Card c, Card c2) {
            int val = c.suit.compareTo(c2.suit);
            if (val == 0) {
                val = c.rank.compareTo(c2.rank);
            }

            return val;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("****************\nCard:\n");
        str.append("\tRank: ").append(this.rank);
        str.append("\n\tSuit: ").append(this.suit);
        str.append("\n****************\n");
        return str.toString();
    }

    @Override
    public int compareTo(Card o) {
        return this.rank.compareTo(o.rank);
    }

}
