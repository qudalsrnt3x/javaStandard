package Chapter07.day14;

public class CastingTest2 {
    public static void main(String[] args) {
        // Car 인스턴스 생성하고 Car타입의 car 참조변수가 참조
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine) car; // 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다.ㅌ
        fe.drive();
        car2 = fe;
        car2.drive();
    }
}
