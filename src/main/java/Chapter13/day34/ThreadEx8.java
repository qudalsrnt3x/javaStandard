package Chapter13.day34;

public class ThreadEx8 {
    public static void main(String[] args) {

        // main 메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드 내에서 생성되는 쓰레드는 기본적으로 우선순위가 5가 된다.
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        th2.setPriority(7); // 쓰레드를 실행하기 전에만 우선순위를 바꿀 수 있다.

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}

class ThreadEx8_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++);
        }
    }
}

class ThreadEx8_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++);
        }
    }
}
