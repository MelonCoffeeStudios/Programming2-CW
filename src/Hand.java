import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by aarongriffin on 10/01/2017.
 */
public class Hand implements Serializable, Iterable<Card> {

    public static final long serialVersionUID = 102;

    ArrayList<Card> hand = new ArrayList<Card>();
    int[] counter = new int[13];
    int handValue = 0;

    /**
     * Default Constructor
     */
    public Hand() {
        hand = new ArrayList();
    }

    /**
     * ArrayList constructor
     * @param hand
     */
    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
        this.handValue = calculateValue(hand);
    }

    /**
     * Hand constructor
     * @param hand
     */
    public Hand(Hand hand) {
        this.hand = hand.hand;
        this.handValue = calculateValue(hand.hand);
    }

    public int calculateValue(ArrayList<Card> h){
        int tmp = 0;
        for(Card c : h){
            tmp += c.getRank().getRankValue();
        }
        return tmp;
    }

    public void clearHand(){
        this.hand = new ArrayList<Card>();
        updateCounter();
    }

    public int size(){
        return hand.size();
    }

    public ArrayList<Card> toArrayList(){
        return this.hand;
    }

    public ArrayList<Card> toArrayList(Hand c){
        return c.hand;
    }

    public void addCard(Card c) {
        if (c == null) {
            throw new NullPointerException("Added null card to Hand");
        }
        hand.add(c);
        updateCounter();
    }

    public void updateCounter(){
        counter = new int[13];
        for(Card c : hand){
            counter[c.getRank().ordinal()]++;
        }
    }

    public int [] getCounter(){
        return this.counter;
    }

    public String getCounterString(){
        String str = "";
        for(int i = 0; i < counter.length; i++){
            str += counter[i] + ",\t";
        }
        return str;
    }

    public boolean remove(Card c) throws CardNotFoundException {
        if(hand.contains(c)){
            hand.remove(c);
            updateCounter();
            return true;
        }else {
            throw new CardNotFoundException("Card matching input not found in hand");
        }
    }

    public boolean remove(Card c, Hand h) throws CardNotFoundException {
        if(h.hand.contains(c)){
            h.hand.remove(c);
            updateCounter();
            return true;
        }else {
            throw new CardNotFoundException("Card matching input not found in hand");
        }
    }

    public boolean remove(Hand h) throws HandNotFoundException {
        if(h == null){
            throw new HandNotFoundException("Hand does not exist");
        }else {
            h.clearHand();
            return true;
        }
    }

    public Card remove(int i){
        if(this.hand.get(i) != null){
            Card tmpCard = this.hand.get(i);
            this.hand.remove(i);
            updateCounter();
            return tmpCard;
        }else{
            throw new ArrayIndexOutOfBoundsException("No card at selected index");
        }

    }

    public Hand sortAscending(Hand h){
        Collections.sort(h.hand);

        return h;
    }

    public Hand sortDescending(Hand h){
        Collections.sort(h.hand, Collections.reverseOrder());

        return h;
    }

    public int countSuit(Card.Suit suit){
        int tmp = 0;
        for(Card c : hand){
            if(c.getSuit() == suit){
                tmp++;
            }
        }
        return tmp;
    }

    public int countSuit(Card.Suit suit, Hand h){
        int tmp = 0;
        for(Card c : h.hand){
            if(c.getSuit() == suit){
                tmp++;
            }
        }
        return tmp;
    }

    public int countRank(Card.Rank rank){
        int tmp = 0;
        for(Card c : hand){
            if(c.getRank() == rank){
                tmp++;
            }
        }
        return tmp;
    }

    public int countRank(Card.Rank rank, Hand h){
        int tmp = 0;
        for(Card c : h.hand){
            if(c.getRank() == rank){
                tmp++;
            }
        }
        return tmp;
    }

    public boolean isFlush(){
        boolean tmp = true;
        Card.Suit firstSuit = hand.get(0).getSuit();
        for(Card c : hand){
            if(c.getSuit() != firstSuit){
                tmp = false;
            }
        }
        return tmp;
    }






    @Override
    public Iterator<Card> iterator() {
        return hand.iterator();
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder("****************\n");
        string.append("  Hand Details\n");
        string.append("****************\n");
        for(Card c : hand){
            string.append(c.toString()).append("\n");
        }

        return string.toString();
    }

}
