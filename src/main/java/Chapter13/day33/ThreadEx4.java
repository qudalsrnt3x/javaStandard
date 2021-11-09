package Chapter13.day33;

public class ThreadEx4 {
    public static void main(String[] args) {

        // 싱글쓰레드에서 수행시간 확인

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1: " + (System.currentTimeMillis() - startTime));

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간2: " + (System.currentTimeMillis() - startTime));
    }
}
