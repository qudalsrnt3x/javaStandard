package Chapter13.day35;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup(); // 현재 쓰레드의 그룹을 가져온다.
        // main쓰레드의 그룹은 main
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

//        ThreadGroup(ThreadGroup, parent, String, name)
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");   // grp1의 하위 쓰레드 그룹 생성

        grp1.setMaxPriority(3); // 쓰레드 그룹 grp1의 최대우선순위를 3으로 변경

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        };

        // Thread(ThreadGroup tg, Runnable r, String name)
        new Thread(grp1, r, "th1").start(); // grp1쓰레드 그룹의 th1이라는 쓰레드 생성 후 start
        new Thread(subGrp1, r, "th2").start();
        new Thread(grp2, r, "th3").start();

        System.out.println(">>List of ThreadGroup: "+ main.getName() + ", Active ThreadGroup: "+main.activeCount()
        +", Active Thread: "+main.activeCount());

        main.list();
    }

}
