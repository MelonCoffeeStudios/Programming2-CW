/**
 * Created by aarongriffin on 10/01/2017.
 */
import java.io.Serializable;

public class Card implements Serializable, Comparable<Card>{



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
            JACK.rankValue = 11;
            QUEEN.rankValue = 11;
            KING.rankValue = 11;
            ACE.rankValue = 11;
        }

        public Rank getNext(){
            return this.rankArray[(this.ordinal()+1) % this.rankArray.length];
        }

        public int getRankValue() {
            return this.rankValue;
        }
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

    public enum Suit {CLUB, DIAMOND, HEART, SPADE}
    Rank rank;
    Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }





    @Override
    public int compareTo(Card o) {
        return this.rank.compareTo(o.rank);
    }

}
