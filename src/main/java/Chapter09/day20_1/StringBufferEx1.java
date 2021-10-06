package Chapter09.day20_1;

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("sb == sb2 ? " + (sb == sb2));
        System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));
        // stringBuffer는 equals 메서드를 오버라이드 하지 않음, 그래서 ==와 같게 나옴
        // 객체를 ==로 비교하면 객체의 주소값을 비교한다.

        // StringBuffer 의 내용을 String으로 변환한다.
        String s = sb.toString();
        String s2 = sb.toString();

        System.out.println("s.equals(s2) ? " + s.equals(s2));
    }
}
