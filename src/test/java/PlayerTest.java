import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest{

    private Player player;
    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void before(){
        player = new Player("player1");
        card1 = new Card(SuitType.SPADES, RankType.SEVEN);
    }

    @Test
    public void canGetName(){
        assertEquals("player1", player.getName());
    }

    @Test
    public void hasCards(){
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void canAddCard(){
        player.addCard(card1);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canSumCardValues(){
        player.addCard(card1);
        card2 = new Card(SuitType.SPADES, RankType.FOUR);
        card3 = new Card(SuitType.SPADES, RankType.QUEEN);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(21, player.getCardTotal());
    }

    @Test
    public void canFindBlackjack(){
        player.addCard(card1);
        card2 = new Card(SuitType.SPADES, RankType.FOUR);
        card3 = new Card(SuitType.SPADES, RankType.QUEEN);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(true, player.hasBlackjack());
    }

}
