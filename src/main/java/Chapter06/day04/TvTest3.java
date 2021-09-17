package Chapter06.day04;

public class TvTest3 {
    public static void main(String[] args) {

        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel의 값은 "+t1.channel +" 입니다.");
        System.out.println("t2의 channel의 값은 "+t2.channel +" 입니다.");

        t2 = t1; // t1이 저장하고 있는 값(주소)을 t2에 저장한다.
        t1.channel = 7;
        System.out.println("tv1의 channel의 값을 7로 변경");

        System.out.println("t1의 channel의 값은 "+t1.channel +" 입니다.");
        System.out.println("t2의 channel의 값은 "+t2.channel +" 입니다.");
    }
}
