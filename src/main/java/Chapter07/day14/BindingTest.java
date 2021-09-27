package Chapter07.day14;

public class BindingTest {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        System.out.println("p.x = " + p.x); // 참조변수의 타입에 따라서 멤버변수 호출 값이 달라진다.
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    int x = 200;

    void method() {
        System.out.println("Chile Method");
    }
}
