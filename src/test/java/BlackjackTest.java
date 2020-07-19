import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlackjackTest {

    private Blackjack blackjack;
    private Player player1;
    private Player player2;
    private Player player3;
    private ArrayList<Player> players;

    @Before
    public void before() {
        players = new ArrayList<Player>();
        player1 = new Player("one");
        player2 = new Player("two");
        player3 = new Player("three");
        players.add(player1);
        players.add(player2);
//        players.add(player3);
        blackjack = new Blackjack(players);
    }

    @Test
    public void hasPlayers(){
        assertEquals(3, blackjack.getPlayers().size());
    }

    @Test
    public void canAddDeck(){
        blackjack.populateDeck();
        assertEquals(52, blackjack.getDeck().getCards().size());
    }

    @Test
    public void canDealCards(){
        blackjack.populateDeck();
        blackjack.dealCards();
        assertEquals(2, player1.getCards().size());
        assertEquals(2, player2.getCards().size());
        assertEquals(2, player3.getCards().size());
        assertEquals(2, blackjack.getDealer().getCards().size());
        assertEquals(44, blackjack.getDeck().getCards().size());
    }

    @Test
    public void canHit(){
        blackjack.populateDeck();
        blackjack.dealCards();
        blackjack.playerHit(player1);
        blackjack.dealerHit();
        assertEquals(3, player1.getCards().size());
        assertEquals(3, blackjack.getDealer().getCards().size());
        assertEquals(42, blackjack.getDeck().getCards().size());
    }

    @Test
    public void playerCanWin(){
        player1.addCard(new Card(SuitType.HEARTS, RankType.KING));
        player1.addCard(new Card(SuitType.SPADES, RankType.QUEEN));
        player2.addCard(new Card(SuitType.CLUBS, RankType.KING));
        player2.addCard(new Card(SuitType.DIAMONDS, RankType.QUEEN));
        player2.addCard(new Card(SuitType.DIAMONDS, RankType.FIVE));
        blackjack.getDealer().addCard(new Card(SuitType.CLUBS, RankType.TWO));
        blackjack.getDealer().addCard(new Card(SuitType.DIAMONDS, RankType.TWO));
        blackjack.findWinner();
        assertEquals(1, blackjack.findWinner().size());
    }

    @Test
    public void dealerCanWin(){
        player1.addCard(new Card(SuitType.CLUBS, RankType.TEN));
        player1.addCard(new Card(SuitType.DIAMONDS, RankType.TEN));
        player1.addCard(new Card(SuitType.DIAMONDS, RankType.TWO));
        blackjack.getDealer().addCard(new Card(SuitType.HEARTS, RankType.KING));
        blackjack.getDealer().addCard(new Card(SuitType.SPADES, RankType.QUEEN));
        assertEquals(true, blackjack.dealerWin());
    }

}
