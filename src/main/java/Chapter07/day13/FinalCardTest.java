package Chapter07.day13;

class Card {
    final int NUMBER;           // 상수지만 선언과 함께 초기화 하지 않고
    final String KIND;          // 생성자에서 단 한번만 초기화할 수 있다.
    static int width = 100;
    static int height = 250;

    Card(String kind, int num) {
        KIND = kind;
        NUMBER = num;
    }

    Card() {
        this("HEART", 1);
    }

    public String toString() {
        return KIND + ", " + NUMBER;
    }
}

public class FinalCardTest {
    public static void main(String[] args) {
        Card card = new Card("HEART", 10);
        //card.NUMBER = 5; // cannot assign a value to final variable NUMVER
        System.out.println("card.KIND = " + card.KIND);
        System.out.println("card.NUMBER = " + card.NUMBER);
        System.out.println("card = " + card);
    }
}
