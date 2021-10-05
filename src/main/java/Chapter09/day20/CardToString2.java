package Chapter09.day20;

class Card2 {
    String kind;
    int number;

    Card2() {
        this("SPADE", 1);
    }

    Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card2{" +
                "kind='" + kind + '\'' +
                ", number=" + number +
                '}';
    }
}

public class CardToString2 {
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
