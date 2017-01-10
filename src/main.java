/**
 * Created by aarongriffin on 10/01/2017.
 */
public class main {
    public static void main(String [] args)
    {
        Card c1 = new Card(Card.Rank.TWO, Card.Suit.HEART);

        System.out.println(c1.rank.getNext());

    }
}
