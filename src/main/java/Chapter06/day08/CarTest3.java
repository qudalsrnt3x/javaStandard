package Chapter06.day08;

class Car3 {
    String color;
    String gearType;
    int door;

    Car3() {
        this("white", "auto", 4);
    }

    Car3(Car3 car) {
        color = car.color;
        gearType = car.gearType;
        door = car.door;
    }

    public Car3(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car3{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}

public class CarTest3 {
    public static void main(String[] args) {
        Car3 c1 = new Car3();
        Car3 c2 = new Car3(c1); // c1의 복사본 c2를 생성한다.

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        c1.door = 100; // c1의 인스턴스변수 door의 값을 변경한다.

        System.out.println("c1.door=100; 수행 후");

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
    }
}
