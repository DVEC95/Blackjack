import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;
    private int primaryCardTotal;
    private int secondaryCardTotal;

    public Dealer() {
        this.cards = new ArrayList<Card>();
        this.primaryCardTotal = 0;
        this.secondaryCardTotal = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public int getCardTotal(){
        int cardTotal = 0;
        for (Card card : this.cards){
            cardTotal += card.getPrimaryValue();
        }
        return cardTotal;
    }

}
