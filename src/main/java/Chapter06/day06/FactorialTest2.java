package Chapter06.day06;

public class FactorialTest2 {
    static long factorial(int n) {
        if(n <= 0 || n > 20) return -1; // 매개변수 유효성 검사 // 0 <= n < 20
        if(n <= 1) return 1; // n<= 1 이면 1
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 21;
        long result = 0;

        for (int i = 1; i <= n; i++) { // 1 ~ 21까지 반복문
            result = factorial(i);

            if (result == -1) { // n이 21인 경우 return -1 이기 때문에 break 걸림
                System.out.printf("유효하지 않은 값입니다.(0<n<20) : %d%n", n);
                break;
            }
            System.out.printf("%2d! =%20d%n", i, result);
        }
    }
}
