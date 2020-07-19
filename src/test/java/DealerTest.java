import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest{

    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.SPADES, RankType.SEVEN);
    }

    @Test
    public void hasCards(){
        assertEquals(0, dealer.getCards().size());
    }

    @Test
    public void canAddCard(){
        dealer.addCard(card1);
        assertEquals(1, dealer.getCards().size());
    }

    @Test
    public void canSumCardValues(){
        dealer.addCard(card1);
        card2 = new Card(SuitType.SPADES, RankType.FOUR);
        card3 = new Card(SuitType.SPADES, RankType.QUEEN);
        dealer.addCard(card2);
        dealer.addCard(card3);
        assertEquals(21, dealer.getCardTotal());
    }

}
