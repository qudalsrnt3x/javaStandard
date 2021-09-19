package Chapter06.day06;

public class ReferenceReturnEx {
    public static void main(String[] args) {
        Data d = new Data(); // 인스턴스 생성
        d.x = 10; // d.x 의 값을 10으로 변경

        Data d2 = copy(d); // copy 메소드 생성 반환값 -> Data
        System.out.println("d.x = " + d.x);
        System.out.println("d2.x = " + d2.x);
    }

    static Data copy(Data data) {
        Data tmp = new Data();
        tmp.x = data.x;

        return tmp; // 반환값이 Data 객체의 주소가 반환된다.
    }
}
