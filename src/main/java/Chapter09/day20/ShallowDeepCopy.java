package Chapter09.day20;

// 깊은 복사, 얕은 복사

class Circle implements Cloneable {
    Point p;
    double r;

    Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {   // 얕은 복사
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (Circle) obj;
    }

    public Circle deepCopy() { // 깊은 복사
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        Circle c = (Circle) obj;
        c.p = new Point(this.p.x, this.p.y);
        return c;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "p=" + p +
                ", r=" + r +
                '}';
    }
}

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();   // 얕은 복사
        Circle c3 = c1.deepCopy();  // 깊은 복사

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);

        c1.p.x = 9;
        c1.p.y = 9;

        System.out.println("= c1의 변경 후 =");
        System.out.println("c1 = " + c1);   // 변경
        System.out.println("c2 = " + c2);   // 같은 객체라서 변경
        System.out.println("c3 = " + c3);   // 다른 객체라서 변경 x
    }
}
