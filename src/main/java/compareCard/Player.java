package compareCard;

import java.util.List;

public class Player {
    String name;
    List<Card> cards;
    Integer level;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public Player(String name, List<Card> cards, Integer level) {
        this.name = name;
        this.cards = cards;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
