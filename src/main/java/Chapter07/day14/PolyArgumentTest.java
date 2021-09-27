package Chapter07.day14;

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv()); // Tv생성 시 100만원으로 초기화
        b.buy(new Computer());

        System.out.println("현재 남은 돈은 " + b.money + " 입니다.");
        System.out.println("현재 보너스 점수는 "+ b.bonusPoint + " 입니다");
    }
}

class Product {
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스포인트

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0); // 보너스점수는 제품가격의 10%
    }
}

class Tv extends Product {
    Tv() {
        // 조상클래스의 생성자 Product(int price)를 호출한다.
        super(100); // Tv가격을 100만원으로 한다.
    }

    // Object클래스의 toString()을 오버라이드
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Buyer { // 고객, 물건을 사는 사람
    int money = 1000; // 소유금액
    int bonusPoint = 0; // 보너스점수

    Product[] item = new Product[10]; //   구입한 제품을 저장하기 위한 배열
    int i = 0; // Product배열 item에 사용될 index

    void buy(Product product) {
        if (money < product.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= product.price; //  가진 돈에서 상품가격 뺀다.
        bonusPoint += product.bonusPoint;  // 제품의 보너스점수 추가
        item[i++] = product; // 제품을 Product[] item에 저장한다.
        System.out.println(product + "을 구입하셨습니다.");
    }
}