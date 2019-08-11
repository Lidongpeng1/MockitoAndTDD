package compareCard;


public class Compare {

    public String compare(Player playerOne,Player playerTwo){
        int playerOneMaxCard = 0;
        int playerTwoMaxCard = 0;
        for(Card item:playerOne.getCards()){
            if(item.getNumber()> playerOneMaxCard){
                playerOneMaxCard = item.getNumber();
            }
        }
        for(Card item:playerTwo.getCards()){
            if(item.getNumber()> playerTwoMaxCard){
                playerTwoMaxCard = item.getNumber();
            }
        }

        if(playerOneMaxCard > playerTwoMaxCard){
            return playerOne.getName();
        }else if(playerOneMaxCard == playerTwoMaxCard){
            return "平手";
        }else {
            return playerTwo.getName();
        }
    }

    public boolean isLevelNine(Player playerOne) {
        return false;
    }
}
