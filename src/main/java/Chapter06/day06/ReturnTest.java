package Chapter06.day06;

public class ReturnTest {

    public static void main(String[] args) {
        ReturnTest r = new ReturnTest(); // 메소드 사용을 위해 인스턴스 객체 생성

        int result = r.add(3, 5); // add메소드의 반환값을 result변수에 담아준다.
        System.out.println(result);

        int[] result2 = {0}; // 배열을 생성하고 result2[0]의 값을 0으로 초기화
        r.add(3, 5, result2); // 배열을 add메서드의 매개변수로 전달
        System.out.println(result2[0]);
    }

    int add(int a, int b) {
        return a + b;
    }

    void add(int a, int b, int[] result){ // 반환값이 없어도 배열을 통해서 값을 담아준다.
        result[0] = a + b;
    }


}
