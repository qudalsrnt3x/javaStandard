package Chapter08.day18;

public class ExceptionEx7 {
    public static void main(String[] args) {
        // 두 개의 catch 블럭 사용하기, 해당 블럭에 맞는 catch블럭이 있으면 처리 후 밑에 블럭은 검사하지 않게 됨


        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4);
        } catch (ArithmeticException e) {
            if (e instanceof ArithmeticException) {
                System.out.println("true");
            }
            System.out.println("ArithmeticException");
        } catch (Exception ee) {
            System.out.println("Exception");
        }
        System.out.println(6);
    }
}
