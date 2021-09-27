package Chapter07.day14;

public class BindingTest3 {
    public static void main(String[] args) {
        Parent3 p = new Child3();
        Child3 c = new Child3();

        System.out.println("p.x = " + p.x); // 100 참조변수의 타입에 해당하는 멤버변수 호출
        p.method(); //

        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent3 {
    int x = 100;
    
    void method() {
        System.out.println("Parent Method");
    }
}

class Child3 extends Parent3 {
    int x = 200;
    
    void method() {
        System.out.println("x = " + x);
        System.out.println("super.x = " + super.x);
        System.out.println("this.x = " + this.x);
    }
}

