import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private int primaryCardTotal;
    private int secondaryCardTotal;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.primaryCardTotal = 0;
        this.secondaryCardTotal = 0;
    }

    public String getName() {
        return name;
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

    public boolean hasBlackjack(){
        if (getCardTotal() == 21){
            return true;
        }
        else {
            return false;
        }
    }

}