package Chapter13.day36;

public class ThreadEx10 implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());    // Runnable 구현한 클래스를 통해 쓰레드 생성
        t.setDaemon(true);  // 이 부분이 없으면 종료되지 않는다.
        t.start();  // start() 전에 setDaemon 메서드를 실행해야 한다.

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println(i);

            if (i == 5) {
                autoSave = true;
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {}

            // autoSave의 값이 true면 autoSave()를 호출한다.
            if (autoSave)
                autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업 파일이 저장되었습니다.");
    }
}
