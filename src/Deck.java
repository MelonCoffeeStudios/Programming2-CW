import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by aarongriffin on 10/01/2017.
 */
public class Deck implements Serializable{

    public static final long serialVersionUID = 101;

    ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(){
        newDeck();
    }

    public void newDeck(){
        deck = new ArrayList<Card>();
        for(Card.Suit s : Card.Suit.values()){
            for(Card.Rank r : Card.Rank.values()){
                deck.add(new Card(r, s));
            }
        }
    }

    public Card deal(){
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }

    public ArrayList<Card> toArrayList(){
        return this.deck;
    }

    public ArrayList<Card> toArrayList(Deck d){
        return d.deck;
    }

    public void shuffleDeck(){
        for (int i = 0; i < 15; i++){
            shuffleOnce();
        }
    }

    public void shuffleOnce(){
        Random random = ThreadLocalRandom.current();
        for(int i = deck.size() -1 ; i > 0; i--){
            int index = random.nextInt(i + 1);

            Card c = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, c);
        }
    }

    public class OddEvenIterator implements Iterator<Card> {

        Deck iteratorDeck;
        int n;
        int round = 1;

        public OddEvenIterator(Deck deck) {
            this.iteratorDeck=deck;
            n=0;
        }

        @Override
        public boolean hasNext () {

            return !(n>deck.size() &&  round == 2);

        }

        @Override
        public Card next() {
            Card c = iteratorDeck.deck.get(n);
            n = n + 2;
            if (n >= deck.size() && round == 1) {
                n=1;
                round=2;
            }
            return c;

        }

    }


    @Override
    public String toString(){
        StringBuilder string = new StringBuilder("****************\n");
        string.append("  Deck Details\n");
        string.append("****************\n");
        for(Card c : deck){
            string.append(c.toString()).append("\n");
        }

        return string.toString();
    }


}
