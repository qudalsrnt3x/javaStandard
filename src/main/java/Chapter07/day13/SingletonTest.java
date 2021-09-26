package Chapter07.day13;

final class Singleton {
    private static Singleton s = new Singleton();

    private Singleton(){
        //...
    }

    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }

        return s;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        //Singleton s = new Singleton();  // 생성자가 private이기 때문에 인스턴스 생성 불가
        Singleton s = Singleton.getInstance(); // Singleton 클래스에서 만든 public 메서드인 getInstance를 통해 인스턴스 불러오기
    }
}
