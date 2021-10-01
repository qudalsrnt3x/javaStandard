package Chapter08.day18;

public class ExceptionEx8 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4);
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace(); // 참조변수 arithmeticException 인스턴스에 접근할 수 있다.
            System.out.println("예외 메시지 : " + arithmeticException.getMessage());
        }
        System.out.println(6);
    }
}
