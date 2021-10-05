package Chapter08.day19;

public class FinallyTest3 {
    public static void main(String[] args) {
        method1();
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
    }
    
    static void method1() {
        try {
            System.out.println("method1()이 호출되었습니다.");
            return; // 현재 실행 중인 메서드를 종료
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1()의 finally블럭이 실행됨");
        }
    } // method1 종료

    // try, catch문에 return 문이 있어도 finally 블럭은 무조건 실행된다.
}
