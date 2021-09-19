package Chapter06.day06;

class Data {
    int x;
}

public class PrimitiveParamEx {
    public static void main(String[] args) {
        Data d = new Data(); // 인스턴스 객체 생성
        d.x = 10; // d.x에 10 대입
        System.out.println("main() : x = " + d.x); // d.x 출력 => 10

        change(d.x); // change(d.x) 를 통해 x = 10000 대입
        System.out.println("After change(d.x)"); // change(d.x) 출력
        System.out.println("main() : x = " + d.x); // d.x 출력 => 10??

        // main 메소드의 d.x를 변경한 것이 아니라 change메소드에 있는 x를 변겨한 것
    }

    static void change(int x) {
        x = 100000;
        System.out.println("change() : x = " + x);
    }
}
