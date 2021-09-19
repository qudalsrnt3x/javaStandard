package Chapter06.day06;

public class MyMathTest {
    public static void main(String[] args) {
        MyMath m1 = new MyMath();

        long result1 = m1.add(5L, 4L);
        long result2 = m1.substract(5L, 1L);
        long result3 = m1.multiply(4L, 3L);
        long result4 = m1.divide(5L, 3L);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }
}

class MyMath {
    long add(long a, long b) {
        long result = a + b;
        return result;
    }

    long substract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    long divide(long a, long b) {
        return a / b;
    }
}
