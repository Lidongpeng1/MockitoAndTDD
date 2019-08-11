package compareCard;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Compare {


    public String compare(Player playerOne, Player playerTwo) {
        playerOne.setLevel(this.getCardslevel(playerOne));
        playerTwo.setLevel(this.getCardslevel(playerTwo));
        if(playerOne.getLevel()>playerTwo.getLevel()){
            return playerOne.getName();
        }
        if(playerOne.getLevel()<playerTwo.getLevel()){
            return playerTwo.getName();
        }
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

    public int getCardslevel(Player player){
        if(this.isLevelNine(player)){return 9;}
        if(this.isLevelEight(player)){return 8;}
        if(this.isLevelSeven(player)){return 7;}
        if(this.isLevelSix(player)){return 6;}
        if(this.isLevelFive(player)){return 5;}
        if(this.isLevelfour(player)){return 4;}
        if(this.isLevelThree(player)){return 3;}
        if(this.isLevelTwo(player)){return 2;}
        return 1;
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

    public Boolean isLevelSeven(Player player) {
        List<Integer> cardsNumber = new ArrayList<>();
        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
        HashSet<Integer> noequalSet = new HashSet<>(cardsNumber);//set自动删除重复元素
        if(noequalSet.size()!=2){
            return false;
        }
        int setNumberOneCount = 0;
        int setNumberTwoCount = 0;
        List<Integer> noequalList = new ArrayList<>(noequalSet);//重新给list方便取值
        for(Integer item:cardsNumber){
            if(item == noequalList.get(0)){
                setNumberOneCount++;
            }
            if(item == noequalList.get(1)){
                setNumberTwoCount++;
            }
        }
        if(setNumberOneCount != 3 && setNumberTwoCount !=3){
            return false;
        }
        return true;
    }

    public Boolean isLevelSix(Player player) {
        List<String> cardsStringNumbers = new ArrayList<>();
        for (Card item : player.getCards()) {
            cardsStringNumbers.add(item.getStringNumber());
        }
        for (String item:cardsStringNumbers){  //判断花色是否一样
            if(!cardsStringNumbers.get(0).substring(1).equals(item.substring(1))){
                return false;
            }
        }
        return true;
    }

    public Boolean isLevelFive(Player player) {
        int cardSize = player.getCards().size();
        List<Integer> cardsNumber = new ArrayList<>();
        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
//        boolean isSame = cardsStringNumbers.stream().allMatch(cardsStringNumber -> cardsStringNumber.substring(1).equals(cardsStringNumbers.get(0).substring(1)));
        for (int k = 0; k <= cardSize - 2; k++) {  //判断是否为顺子
            if (cardsNumber.get(k)+1 != cardsNumber.get(k+1)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isLevelfour(Player player) {
        List<Integer> cardsNumber = new ArrayList<>();
        int setNumOneCount = 0;
        int setNumTwoCount = 0;
        int setNumThreeCount = 0;

        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
        HashSet<Integer> noequalSet = new HashSet<>(cardsNumber);//set自动删除重复元素
        List<Integer> noequalList = new ArrayList<>(noequalSet);//重新给list方便取值
        if(noequalSet.size()!=3){
            return false;
        }
        for(Integer item:cardsNumber){
            if(item == noequalList.get(0)){
                setNumOneCount++;
            }
            if(item == noequalList.get(1)){
                setNumTwoCount++;
            }
            if(item == noequalList.get(2)){
                setNumThreeCount++;
            }
        }
        if(setNumOneCount != 3 && setNumTwoCount !=3 &&setNumThreeCount !=3){
            return false;
        }
        return true;
    }

    public Boolean isLevelThree(Player player) {
        List<Integer> cardsNumber = new ArrayList<>();
        int setNumOneCount = 0;
        int setNumTwoCount = 0;
        int setNumThreeCount = 0;

        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
        HashSet<Integer> noequalSet = new HashSet<>(cardsNumber);//set自动删除重复元素
        List<Integer> noequalList = new ArrayList<>(noequalSet);//重新给list方便取值
        if(noequalSet.size()!=3){
            return false;
        }
        for(Integer item:cardsNumber){
            if(item == noequalList.get(0)){
                setNumOneCount++;
            }
            if(item == noequalList.get(1)){
                setNumTwoCount++;
            }
            if(item == noequalList.get(2)){
                setNumThreeCount++;
            }
        }
        if(setNumOneCount >=3 || setNumTwoCount >= 3 || setNumThreeCount >= 3){
            return false;
        }
        return true;
    }

    public Boolean isLevelTwo(Player player) {
        List<Integer> cardsNumber = new ArrayList<>();

        for (Card item : player.getCards()) {
            cardsNumber.add(item.getNumber());
        }
        HashSet<Integer> noequalSet = new HashSet<>(cardsNumber);//set自动删除重复元素
        if (noequalSet.size() != 4) {
            return false;
        }
        return true;
    }
}
