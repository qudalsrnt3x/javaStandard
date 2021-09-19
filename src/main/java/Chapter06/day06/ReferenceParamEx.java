package Chapter06.day06;


public class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d); // change변수에 값이 아닌 값을 저장한 주소를 보냈기 때문에
        System.out.println("after change(d)");
        System.out.println("main() : x = " + d.x); // 같은 주소여서 값이 변한다.
    }

    static void change(Data d) {
        d.x = 1000;
        System.out.println("change() : x = " + d.x);
    }
}


