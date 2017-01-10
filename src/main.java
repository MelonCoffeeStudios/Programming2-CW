/**
 * Created by aarongriffin on 10/01/2017.
 */
import java.util.Arrays;

public class main {
    public static void main(String [] args)
    {
        Card c1 = new Card(Card.Rank.TWO, Card.Suit.CLUB);
        Card c2 = new Card(Card.Rank.SIX, Card.Suit.HEART);
        Card c3 = new Card(Card.Rank.TEN, Card.Suit.SPADE);
        Card c4 = new Card(Card.Rank.TEN, Card.Suit.DIAMOND);
        Card[] cards = {c3, c1, c4, c2};

        Arrays.sort(cards);
        for(Card c : cards){
            System.out.println(c.rank + " " + c.suit);
        }

        System.out.println(c1.rank.getNext());

    }
}
