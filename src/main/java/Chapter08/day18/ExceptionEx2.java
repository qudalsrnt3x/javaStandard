package Chapter08.day18;

public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            result = number / (int)(Math.random() * 10); // 0 ~ 9 까지 임의의 수
            System.out.println(result);

            // 0으로 값을 나누려고 했기 때문에 ArithmeticException 발생
        }
    } // main
}
