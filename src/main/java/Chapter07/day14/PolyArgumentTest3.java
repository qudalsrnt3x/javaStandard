package Chapter07.day14;

import java.util.Vector;

class Product3 {
    int price;
    int bonusPoint;

    Product3(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }

    Product3() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv3 extends Product3 {
    Tv3() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer3 extends Product3 {
    Computer3() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio3 extends Product3 {
    Audio3() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer3 {
    int money = 1000;
    int bonusPoint = 0;
    Vector item = new Vector();

    void buy(Product3 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println(p + "를 구입하셨습니다.");
    }

    void refund(Product3 p) {
        if (item.remove(p)) {
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println(p + "를 반품하셨습니다.");
        } else {
            System.out.println("구입하신 제품 중 해당 상품이 없습니다.");
        }
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        if (item.isEmpty()) {
            System.out.println("구입하신 제품이 없습니다.");
            return;
        }

        for (int i = 0; i < item.size(); i++) {
            Product3 p = (Product3) item.get(i); // Vector의 i번째 있는 객체를 얻어온다.
            sum += p.price;
            itemList += (i == 0) ? "" + p : ", " + p;
        }
        System.out.println("구입하신 물품의 총 금액은 "+ sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + " 입니다.");
    }
}

public class PolyArgumentTest3 {
    public static void main(String[] args) {
        Buyer3 b = new Buyer3();


        Tv3 tv = new Tv3();
        Computer3 computer = new Computer3();
        Audio3 audio = new Audio3();

        b.buy(tv);
        b.buy(computer);
        b.buy(audio);
        b.summary();
        System.out.println();
        b.refund(computer);
        b.summary();
    }
}
