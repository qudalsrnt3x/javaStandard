package Chapter07.day16;

// 직접 의존하는 경우
// A ---> B
// B가 변경되면 A도 변경해야 한다.

class A {
    public void methodA(B b){
        b.methodB();
    }
}

class B {
    public void methodB() {
        System.out.println("methodB()");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new B());
    }
}
