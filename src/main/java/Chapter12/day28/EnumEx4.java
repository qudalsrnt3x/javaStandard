package Chapter12.day28;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int ordinal() {
        return ordinal;
    }

    MyEnum(String name) {
        this.name = name;
        this.ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.ordinal;
    }
}

abstract class MyTransporation extends MyEnum {

    static final MyTransporation BUS = new MyTransporation("BUS", 100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    static final MyTransporation TRAIN = new MyTransporation("TRAIN", 150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    abstract int fare(int distance);    // 추상 메서드

    protected final int BASIC_FARE;

    private MyTransporation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class EnumEx4 {
    public static void main(String[] args) {
        MyTransporation t1 = MyTransporation.BUS;
        MyTransporation t2 = MyTransporation.BUS;
        MyTransporation t3 = MyTransporation.TRAIN;

        System.out.printf("t1=%s, %d%n", t1.name(), t1.ordinal());
        System.out.printf("t1=%s, %d%n", t2.name(), t2.ordinal());
        System.out.printf("t1=%s, %d%n", t3.name(), t3.ordinal());
        System.out.println("t1.compareTo(t3) = " + t1.compareTo(t3));

    }
}
