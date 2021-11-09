package Chapter13.day33;

public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) {
        Thread5_1 th1 = new Thread5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1:" + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}

class Thread5_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간2:" + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}
