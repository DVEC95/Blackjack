public enum RankType {
    ACE(1, 11),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5, 5),
    SIX(6, 6),
    SEVEN(7, 7),
    EIGHT(8, 8),
    NINE(9, 9),
    TEN(10, 10),
    JACK(10, 10),
    QUEEN(10, 10),
    KING(10, 10);

    private final int primaryValue;
    private final int secondaryValue;

    RankType(int primaryValue, int secondaryValue){
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    public int getPrimaryValue(){
        return this.primaryValue;
    }

    public int getSecondaryValue(){
        return  this.secondaryValue;
    }

}