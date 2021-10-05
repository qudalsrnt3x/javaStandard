package Chapter08.day19;

public class ExceptionEx12 {
    public static void main(String[] args) throws Exception {
        method1();  // 같은 클래스 내의 static 멤버이므로 객체생성 없이 직접 호출가능.
        // main 메서드 끝
        //4. main 메서드에서도 예외처리를 해주지 않아서 main 메서드가 종료되어 프로그램이 예외로 인해 비정상정으로 종료된다.
    }

    static void method1() throws Exception {
        method2();
        // method1 끝
        //3. method1()역시 예외처리를 해주지 않았으므로 main 메서드에게 예외를 넘겨준다.
    }

    static void method2() throws Exception {
        throw new Exception();
        // method2 끝
        //1. method2() 에서 throw new Exception(); 문장을 통해 예외를 발생했다.
        //2. try-catch 문을 사용해서 예외처리를 해주지 않았으므로, method2()는 종료되면서 예외를 method1()에 넘겨준다.
    }

    // 결국 어느 한 곳에서는 반드시 try-catch 문으로 예외처리를 해주어야 한다.
}
