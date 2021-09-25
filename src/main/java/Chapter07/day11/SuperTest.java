package Chapter07.day11;

public class SuperTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10;
}

class Child extends Parent {
    void method() {
        System.out.println("x = " + x); // 부모클래스의 멤버변수를 참조할 수 있음
        System.out.println("this.x = " + this.x); // 부모클래스도 자식클래스에서 사용할 수 있으므로 this 사용 가능
        System.out.println("super.x = " + super.x); // 부모클래스의 멤버변수를 참조할 때 super 사용
    }
}
