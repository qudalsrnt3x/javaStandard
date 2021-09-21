package Chapter06.day08;

class Car2 {
    String color; // 색상
    String gearType; // 변속기 종류
    int door; // 문의 갯수

    Car2(){
        this("white", "auto", 4); // Car2(String color, String gearType, int door) 호출
    }

    Car2(String color) {
        this(color, "auto", 4);
    }

    public Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}

public class CarTest2 {
    public static void main(String[] args) {
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("blue");

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
    }
}
