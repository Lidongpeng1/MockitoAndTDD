package compareCard;


public class Compare {

    public String compare(Player playerOne, Player playerTwo) {
        int playerOneMaxCard = 0;
        int playerTwoMaxCard = 0;
        for (Card item : playerOne.getCards()) {
            if (item.getNumber() > playerOneMaxCard) {
                playerOneMaxCard = item.getNumber();
            }
        }
        for (Card item : playerTwo.getCards()) {
            if (item.getNumber() > playerTwoMaxCard) {
                playerTwoMaxCard = item.getNumber();
            }
        }

        if (playerOneMaxCard > playerTwoMaxCard) {
            return playerOne.getName();
        } else if (playerOneMaxCard == playerTwoMaxCard) {
            return "平手";
        } else {
            return playerTwo.getName();
        }
    }

    public boolean isLevelNine(Player playerOne) {
        int cardSize = playerOne.getCards().size();
        int i = 0;
        int[] cardsNumber = new int[cardSize];
        String[] cardsStringNumber = new String[cardSize];

        for (Card item : playerOne.getCards()) {
            cardsNumber[i] = item.getNumber();
            cardsStringNumber[i] = item.getStringNumber();
            i++;
        }

        for (int j = 0; j <= cardSize - 1; j++) {  //判断花色是否一样
            if (!cardsStringNumber[0].substring(1).equals(cardsStringNumber[j].substring(1))) {
                return false;
            }
        }
        for (int k = 0; k <= cardSize - 2; k++) {  //判断是否为顺子
            if (cardsNumber[k] + 1 != cardsNumber[k + 1]) {
                return false;
            }
        }
        return true;
    }
}
