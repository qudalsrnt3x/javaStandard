package Chapter06.day07;

public class OverloadingTest {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3();
        System.out.println("mm.add(3, 3) = " + mm.add(3, 3));
        System.out.println("mm.add(3L, 3) = " + mm.add(3L, 3));
        System.out.println("mm.add(3, 3L) = " + mm.add(3, 3L));
        System.out.println("mm.add(3L, 3L) = " + mm.add(3L, 3L));

        int[] a = {100, 200, 300};
        System.out.println("mm.add(a) = " + mm.add(a));
    }
}

class MyMath3 {
    int add(int a, int b) {
        System.out.print("MyMath3.add(int a, int b) - ");
        return a + b;
    }

    long add(int a, long b) {
        System.out.print("MyMath3.add(int a, long b) - ");
        return a + b;
    }

    long add(long a, int b) {
        System.out.print("MyMath3.add(long a, int b) - ");
        return a + b;
    }

    long add(long a, long b) {
        System.out.print("MyMath3.add(long a, long b) - ");
        return a + b;
    }

    int add(int[] a) { // 배열의 모든 요소의 합을 결과로 돌려준다.
        System.out.print("MyMath3.add(int[] a) - ");
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }
}
