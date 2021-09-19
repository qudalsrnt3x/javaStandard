package Chapter06.day06;

public class CallStackTest2 {
    public static void main(String[] args) {
        System.out.println("CallStackTest2.main 이 시작되었음");
        firstMethod();
        System.out.println("CallStackTest2.main 이 끝났음.");
    }

    private static void firstMethod() {
        System.out.println("CallStackTest2.firstMethod 이 시작되었음");
        secondMethod();
        System.out.println("CallStackTest2.firstMethod 이 끝났음");
    }

    private static void secondMethod() {
        System.out.println("CallStackTest2.secondMethod 이 시작되었음");
        System.out.println("CallStackTest2.secondMethod 이 끝났음");
    }
}
