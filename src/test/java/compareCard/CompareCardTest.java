package compareCard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompareCardTest {

    @Test
    public void should_return_winner_is_PlayerOne(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("5H");
        Card card2 = new Card("6H");
        Card card3 = new Card("8C");
        Card card4 = new Card("9D");
        Card card5 = new Card("AS");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player playerOne = new Player("playerOne",playerOneCardList);
        List<Card> playerTwoCardList = new ArrayList<>();
        Card card6 = new Card("6C");
        Card card7 = new Card("8D");
        Card card8 = new Card("9H");
        Card card9 = new Card("TD");
        Card card10 = new Card("7S");
        playerTwoCardList.add(card6);
        playerTwoCardList.add(card7);
        playerTwoCardList.add(card8);
        playerTwoCardList.add(card9);
        playerTwoCardList.add(card10);
        Player playerTwo = new Player("playerTwo",playerTwoCardList);

        Compare compare = new Compare();
        String result = compare.compare(playerOne,playerTwo);
        Assert.assertEquals("playerOne",result);
    }

    @Test
    public void should_return_level_is_one(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("5H");
        Card card2 = new Card("6H");
        Card card3 = new Card("8C");
        Card card4 = new Card("9D");
        Card card5 = new Card("AS");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player playerOne = new Player("playerOne",playerOneCardList);
        Compare compare = new Compare();
        int result = compare.getCardslevel(playerOne);
        Assert.assertEquals(1,result);
    }

    @Test
    public void should_return_level_nine_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card(5,"5H");
        Card card2 = new Card(6,"6H");
        Card card3 = new Card(7,"7H");
        Card card4 = new Card(8,"8H");
        Card card5 = new Card(9,"9H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player playerOne = new Player("player",playerOneCardList);

        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelNine(playerOne);
        Assert.assertEquals(true,resultlevel);
    }

    @Test
    public void should_return_level_eight_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card(5,"5S");
        Card card2 = new Card(5,"5H");
        Card card3 = new Card(5,"5H");
        Card card4 = new Card(5,"5H");
        Card card5 = new Card(9,"9H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);

        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelEight(player);
        Assert.assertEquals(true,resultlevel);
    }

    @Test
    public void should_return_level_seven_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card(5,"5S");
        Card card2 = new Card(5,"5H");
        Card card3 = new Card(5,"5H");
        Card card4 = new Card(9,"9H");
        Card card5 = new Card(9,"9H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);

        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelSeven(player);
        Assert.assertEquals(true,resultlevel);
    }
    @Test
    public void should_return_level_six_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("3H");
        Card card2 = new Card("4H");
        Card card3 = new Card("5H");
        Card card4 = new Card("7H");
        Card card5 = new Card("9H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);
        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelSix(player);
        Assert.assertEquals(true,resultlevel);
    }
    @Test
    public void should_return_level_five_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("3C");
        Card card2 = new Card("4D");
        Card card3 = new Card("5H");
        Card card4 = new Card("6S");
        Card card5 = new Card("7H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);
        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelFive(player);
        Assert.assertEquals(true,resultlevel);
    }
    @Test
    public void should_return_level_four_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("3C");
        Card card2 = new Card("3D");
        Card card3 = new Card("3H");
        Card card4 = new Card("6S");
        Card card5 = new Card("7H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);
        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelfour(player);
        Assert.assertEquals(true,resultlevel);
    }
    @Test
    public void should_return_level_three_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("3C");
        Card card2 = new Card("3D");
        Card card3 = new Card("5H");
        Card card4 = new Card("7S");
        Card card5 = new Card("7H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);
        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelThree(player);
        Assert.assertEquals(true,resultlevel);
    }
    @Test
    public void should_return_level_two_is_true(){
        List<Card> playerOneCardList = new ArrayList<>();
        Card card1 = new Card("3C");
        Card card2 = new Card("3D");
        Card card3 = new Card("5H");
        Card card4 = new Card("6S");
        Card card5 = new Card("7H");
        playerOneCardList.add(card1);
        playerOneCardList.add(card2);
        playerOneCardList.add(card3);
        playerOneCardList.add(card4);
        playerOneCardList.add(card5);
        Player player = new Player("player",playerOneCardList);
        Compare compare = new Compare();
        Boolean resultlevel = compare.isLevelTwo(player);
        Assert.assertEquals(true,resultlevel);
    }
}
