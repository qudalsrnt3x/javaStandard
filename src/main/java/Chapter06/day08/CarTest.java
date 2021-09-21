package Chapter06.day08;

class Car {
    String color;
    String gearType;
    int door;

    Car() {} // 기본 생성자

    public Car(String color, String gearType, int door) { // 매개변수가 있는 생성자
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}

public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "white";
        c1.gearType = "auto";
        c1.door = 4;

        Car c2 = new Car("white", "auto", 4);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
    }
}
