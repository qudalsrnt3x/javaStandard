package Chapter07.day11;

public class SuperTest2 {
    public static void main(String[] args) {
        Child2 c2 = new Child2();
        c2.method();
    }
}

class Parent2 {
    int x = 10;
}

class Child2 extends Parent2 {
    int x = 20;

    void method() {
        System.out.println("x = " + x);  // 자신 클래스의 x
        System.out.println("this.x = " + this.x); // 자신 클래스의 x
        System.out.println("super.x = " + super.x); // 부모 클래스의 x 참조
    }
}
