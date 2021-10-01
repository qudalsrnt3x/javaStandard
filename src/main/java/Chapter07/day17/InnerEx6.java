package Chapter07.day17;

// 익명 클래스 만들기
public class InnerEx6 {
    Object iv = new Object() { void method(){}}; // 익명 클래스
    static Object cv = new Object() {void method(){}}; // 익명 클래스

    void mymethod() {
        Object lv = new Object(){void method(){}}; // 익명 클래스
    }

}
