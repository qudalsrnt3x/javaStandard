package Chapter07.day14;

public class CastingTest1 {
    public static void main(String[] args) {
        // Car타입의 참조변수 car를 선언
        Car car = null;

        // FireEngine 인스턴스를 생성하고 FireEngine타입의 참조변수 fe가 참조하도록 한다.
        FireEngine fe = new FireEngine();

        FireEngine fe2 = null;

        fe.water();
        car = fe;   // car = (Car)fe; 에서 형변환 생략 // 조상 클래스는 형변환 생략가능
        //car.water() // Car타입의 참조변수로는 water()를 호출할 수 없다.
        fe2 = (FireEngine) car; // 자손타입 <- 조상타입 다운캐스팅
        fe2.water();
    }
}

class Car {
    String color;
    int door;

    void drive() {  // 운전하는 기능
        System.out.println("drive, Brrr~");
    }

    void stop() {   // 멈추는 기능
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car { // 소방차
    void water() {  // 물을 뿌리는 기능
        System.out.println("water!!!");
    }
}

