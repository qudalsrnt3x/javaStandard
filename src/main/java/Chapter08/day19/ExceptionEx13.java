package Chapter08.day19;

public class ExceptionEx13 {
    public static void main(String[] args) {
        method1();  // 같은 클래스 내의 static 멤버이므로 객체생성없이 직접 호출가능.
    }

    static void method1() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1메서드에서 예외가 처리되었습니다.");
            e.printStackTrace();
        }
    } // method1 끝
    
    // method1 에서 예외처리
}
