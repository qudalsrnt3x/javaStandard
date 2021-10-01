package Chapter08.day18;

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4); // 실행되지 않는다.
        } catch (Exception e) { // ArithmeticException대신 조상클래스인 Exception 클래스 사용
            System.out.println(5);
        }
        System.out.println(6);
    }
}
