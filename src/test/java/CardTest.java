import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void canGetSuit(){
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(RankType.ACE, card.getRank());
    }

    @Test
    public void canGetPrimaryRankValue(){
        assertEquals(1, card.getPrimaryValue());
    }

    @Test
    public void canGetSecondaryValue(){
        assertEquals(11, card.getSecondaryValue());
    }

}
