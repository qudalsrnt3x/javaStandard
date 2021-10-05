package Chapter09.day20;

// clone() 사용

class Point implements Cloneable {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Object clone() {
        Object obj = null;

        try {
            obj = super.clone();    // clone는 반드시 예외처리를 해주어야 한다.
        } catch (CloneNotSupportedException e) { }
        return obj;
    }
}

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point) original.clone();  // 복제해서 새로운 객체를 생성
        System.out.println(original);
        System.out.println(copy);
    }
}
