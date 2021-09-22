package Chapter06.day09;

class Product {
    static int count = 0; // 몀시적초기화, 클래스변수 -> 공유
    int serialNo; // 기본값

    {
        ++count;    // 인스턴스 초기화 블럭 -> 인스턴스가 생성될 때 count값 하나씩 올림
        serialNo = count; // count값을 serialNo에 넣어준다.
    }

    public Product() { // 기본생성자
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        System.out.println("p1.serialNo = " + p1.serialNo);
        System.out.println("p2.serialNo = " + p2.serialNo);
        System.out.println("p3.serialNo = " + p3.serialNo);

    }

}
