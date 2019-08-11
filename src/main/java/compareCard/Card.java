package compareCard;

public class Card {
    private Integer Number;
    private String StringNumber;

    public Card(String stringNumber) {
        StringNumber = stringNumber;
        String i = stringNumber.substring(0,1);
        if(i.equals("T")){i = "10";};
        if(i.equals("J")){i = "11";};
        if(i.equals("Q")){i = "12";};
        if(i.equals("K")){i = "13";};
        if(i.equals("A")){i = "14";};
        Number = Integer.parseInt(i);
    }

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
