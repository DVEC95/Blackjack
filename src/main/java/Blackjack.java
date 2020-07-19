import java.util.ArrayList;

public class Blackjack {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;

    public Blackjack(ArrayList<Player> players){
        this.players = players;
        this.dealer = new Dealer();
        this.deck = new Deck();
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Dealer getDealer(){
        return dealer;
    }

    public Deck getDeck(){
        return deck;
    }

    public void populateDeck(){
        this.deck.populate();
        this.deck.shuffle();
    }

    public void dealCards(){
        for (Player player : this.players){
            player.addCard(this.deck.dealCard());
            player.addCard(this.deck.dealCard());
        }
        dealer.addCard(this.deck.dealCard());
        dealer.addCard(this.deck.dealCard());
    }

    public void playerHit(Player player){
        player.addCard(this.deck.dealCard());
    }

    public void dealerHit(){
        dealer.addCard(this.deck.dealCard());
    }

    public ArrayList<Player> findWinner(){
        ArrayList<Player> winners = new ArrayList<Player>();
        int dealerDifference = (21 - getDealer().getCardTotal());
        for (Player player : this.players){
            int playerDifference = (21 - player.getCardTotal());
            if  (playerDifference < dealerDifference && playerDifference > 0){
                winners.add(player);
            } else if (playerDifference < 0){
                winners = winners;
            }
        }
        return winners;
    }

    public boolean dealerWin(){
        ArrayList<Player> winners = findWinner();
        if (winners.size() == 0 && getDealer().getCardTotal() > 0){
            return true;
        } else {
            return false;
        }
    }

}


