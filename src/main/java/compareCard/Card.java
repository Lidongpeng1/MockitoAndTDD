package compareCard;

public class Card {
    private Integer Number;
    private String StringNumber;

    public Card(Integer number, String stringNumber) {
        Number = number;
        StringNumber = stringNumber;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public String getStringNumber() {
        return StringNumber;
    }

    public void setStringNumber(String stringNumber) {
        StringNumber = stringNumber;
    }
}
