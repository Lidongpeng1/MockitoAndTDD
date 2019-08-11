package compareCard;


import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class Compare {


    public String compare(Player playerOne, Player playerTwo) {
        playerOne.setLevel(this.getCardslevel(playerOne));
        playerTwo.setLevel(this.getCardslevel(playerTwo));
        if (playerOne.getLevel() > playerTwo.getLevel()) {
            return playerOne.getName();
        }
        if (playerOne.getLevel() < playerTwo.getLevel()) {
            return playerTwo.getName();
        }
        return compareEqualLevel(playerOne, playerTwo);
    }

    public String compareEqualLevel(Player playerOne,Player playerTwo){
        if(playerOne.getLevel()==1){
            return compareEqualLevelOne(playerOne,playerTwo);
        }
        if(playerOne.getLevel()==2){
            return compareEqualLevelTwo(playerOne,playerTwo);
        }
        if(playerOne.getLevel()==3){
            return compareEqualLevelThree(playerOne,playerTwo);
        }
        if(playerOne.getLevel()==4){
            return compareEqualLevelFour(playerOne,playerTwo);
        }
        if(playerOne.getLevel()==5){
            return compareEqualLevelFive(playerOne,playerTwo);
        }
        if(playerOne.getLevel()==6){
            return compareEqualLevelSix(playerOne,playerTwo);
        }
        return "null";
    }

    public String compareEqualLevelOne(Player playerOne,Player playerTwo){
        List<Integer> playerOneCards = new ArrayList<>();
        List<Integer> playerTwoCards = new ArrayList<>();
        for (Card item:playerOne.getCards()){
            playerOneCards.add(item.getNumber());
        }
        for (Card item:playerTwo.getCards()){
            playerTwoCards.add(item.getNumber());
        }
        Collections.sort(playerOneCards);
        Collections.sort(playerTwoCards);
        Collections.reverse(playerOneCards);
        Collections.reverse(playerTwoCards);

        for(int i=0;i <= playerOneCards.size()-1;i++){
            if(playerOneCards.get(i) > playerTwoCards.get(i)){
                return playerOne.getName();
            }
            if(playerOneCards.get(i) < playerTwoCards.get(i)){
                return playerTwo.getName();
            }
        }
        return "旗鼓相当的对手";
    }

    public String compareEqualLevelTwo(Player playerOne,Player playerTwo){
        List<Integer> playerOneCards = new ArrayList<>();
        List<Integer> playerTwoCards = new ArrayList<>();
        for (Card item:playerOne.getCards()){
            playerOneCards.add(item.getNumber());
        }
        for (Card item:playerTwo.getCards()){
            playerTwoCards.add(item.getNumber());
        }
        HashSet<Integer> playerOneCardsBySet = new HashSet<>(playerOneCards);//得到去重后的set集合
        HashSet<Integer> playerTwoCardsBySet = new HashSet<>(playerTwoCards);

        Collection playerOneCardsByCollection = CollectionUtils.disjunction(playerOneCards,playerOneCardsBySet);//获取去除的重复元素
        Collection playerTwoCardsByCollection = CollectionUtils.disjunction(playerTwoCards,playerTwoCardsBySet);

        List<Integer> playerOneDoubleCardsNum = new ArrayList<>(playerOneCardsByCollection);
        List<Integer> playerTwoDoubleCardsNum = new ArrayList<>(playerTwoCardsByCollection);


        if(playerOneDoubleCardsNum.get(0) > playerTwoDoubleCardsNum.get(0)){
                return playerOne.getName();
            }
        if(playerOneDoubleCardsNum.get(0) < playerTwoDoubleCardsNum.get(0)){
                return playerTwo.getName();
            }
        return this.compareEqualLevelOne(playerOne,playerTwo);//等级二的对子相同则调用等级一的比较方法
    }

    public String compareEqualLevelThree(Player playerOne,Player playerTwo){
        int playerOneMaxDouble = 0;
        int playerOneMinDouble = 0;
        int playerTwoMaxDouble = 0;
        int playerTwoMinDouble = 0;
        List<Integer> playerOneCards = new ArrayList<>();
        List<Integer> playerTwoCards = new ArrayList<>();
        for (Card item:playerOne.getCards()){
            playerOneCards.add(item.getNumber());
        }
        for (Card item:playerTwo.getCards()){
            playerTwoCards.add(item.getNumber());
        }
        HashSet<Integer> playerOneCardsBySet = new HashSet<>(playerOneCards);//得到去重后的set集合
        HashSet<Integer> playerTwoCardsBySet = new HashSet<>(playerTwoCards);

        Collection playerOneCardsByCollection = CollectionUtils.disjunction(playerOneCards,playerOneCardsBySet);//获取去除的重复元素
        Collection playerTwoCardsByCollection = CollectionUtils.disjunction(playerTwoCards,playerTwoCardsBySet);

        List<Integer> playerOneDoubleCardsNum = new ArrayList<>(playerOneCardsByCollection);
        List<Integer> playerTwoDoubleCardsNum = new ArrayList<>(playerTwoCardsByCollection);

        if(playerOneDoubleCardsNum.get(0) > playerOneDoubleCardsNum.get(1)){
            playerOneMaxDouble = playerOneDoubleCardsNum.get(0);
            playerOneMinDouble = playerOneDoubleCardsNum.get(1);
        }else {
            playerOneMaxDouble = playerOneDoubleCardsNum.get(1);
            playerOneMinDouble = playerOneDoubleCardsNum.get(0);
        }

        if(playerTwoDoubleCardsNum.get(0) > playerTwoDoubleCardsNum.get(1)){
            playerTwoMaxDouble = playerTwoDoubleCardsNum.get(0);
            playerTwoMinDouble = playerTwoDoubleCardsNum.get(1);
        }else {
            playerTwoMaxDouble = playerTwoDoubleCardsNum.get(1);
            playerTwoMinDouble = playerTwoDoubleCardsNum.get(0);
        }

        if(playerOneMaxDouble>playerTwoMaxDouble){
            return playerOne.getName();
        }
        if(playerOneMaxDouble<playerTwoMaxDouble){
            return playerTwo.getName();
        }
        if(playerOneMinDouble>playerTwoMinDouble){
            return playerOne.getName();
        }
        if(playerOneMinDouble<playerTwoMinDouble){
            return playerTwo.getName();
        }
        return this.compareEqualLevelOne(playerOne,playerTwo);
    }

    public String compareEqualLevelFour(Player playerOne,Player playerTwo){
        return compareEqualLevelTwo(playerOne,playerTwo);
    }

    public String compareEqualLevelFive(Player playerOne,Player playerTwo){
        return compareEqualLevelOne(playerOne,playerTwo);
    }

    public String compareEqualLevelSix(Player playerOne,Player playerTwo){
        return compareEqualLevelOne(playerOne,playerTwo);
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
