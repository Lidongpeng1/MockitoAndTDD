package compareCard;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public boolean isLevelNine(Player player) {
        int cardSize = player.getCards().size();
        List<Integer> cardsNumber = new ArrayList<>();
        List<String> cardsStringNumbers = new ArrayList<>();

        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
            cardsStringNumbers.add(item.getStringNumber());
        }

        for (int j = 1; j <= cardSize - 1; j++) {  //判断花色是否一样
            if (!cardsStringNumbers.get(0).substring(1).equals(cardsStringNumbers.get(j).substring(1))) {
                return false;
            }
        }
//        boolean isSame = cardsStringNumbers.stream().allMatch(cardsStringNumber -> cardsStringNumber.substring(1).equals(cardsStringNumbers.get(0).substring(1)));
        for (int k = 0; k <= cardSize - 2; k++) {  //判断是否为顺子
            if (cardsNumber.get(k)+1 != cardsNumber.get(k+1)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isLevelEight(Player player) {
        List<Integer> cardsNumber = new ArrayList<>();
        int setNumOneCount = 0;
        int setNumTwoCount = 0;

        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
        HashSet<Integer> noequalSet = new HashSet<>(cardsNumber);//set自动删除重复元素
        List<Integer> noequalList = new ArrayList<>(noequalSet);//重新给list方便取值
        if(noequalSet.size()!=2){
            return false;
        }
        for(Integer item:cardsNumber){
            if(item == noequalList.get(0)){
                setNumOneCount++;
            }
            if(item == noequalList.get(1)){
                setNumTwoCount++;
            }
        }
        if(setNumOneCount != 4 && setNumTwoCount !=4){
            return false;
        }
        return true;
    }
}
