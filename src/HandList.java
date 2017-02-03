import java.util.ArrayList;

/**
 * Created by aarongriffin on 03/02/2017.
 */
public class HandList {
    ArrayList<Hand> hands = new ArrayList<Hand>();
    int numberOfHands = 4;

    public HandList(){
        initHands();
    }

    public void initHands(){
        for(int i = 1; i <= numberOfHands; i++){
            hands.add(new Hand());
        }
    }

    public void dealToHands(Deck deck, int cardsToDeal){
        for(int i = 0; i < cardsToDeal; i++){
            for(int j = 0; j < numberOfHands;j++){
                hands.get(j).addCard(deck.deal());
            }

        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Hands in play:\n");
        for(Hand h : hands){
            str.append("Hand: " + (hands.indexOf(h) +1) + "\n");
            str.append(h.toString());
        }

        return str.toString();
    }
}
