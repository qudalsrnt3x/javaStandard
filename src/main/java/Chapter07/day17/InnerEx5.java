package Chapter07.day17;

class Outer2 {
    int value = 10; // Outer.this.value

    class Inner {
        int value = 20; // this.value

        void method1() {
            int value = 30;
            System.out.println("    value:" + value);
            System.out.println(" this.value:" + this.value);
            System.out.println("Outer2.this.value:" + Outer2.this.value);
        }
    }   // Inner class

} // Outer2 class

public class InnerEx5 {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        Outer2.Inner inner = outer.new Inner();
        inner.method1();

    }
}
