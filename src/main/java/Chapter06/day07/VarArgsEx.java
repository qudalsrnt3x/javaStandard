package Chapter06.day07;

public class VarArgsEx {
    public static void main(String[] args) {

        // 가변인자 예시

        String[] strArr = {"100", "200", "300"};

        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
        System.out.println("[" + concatenate(",", new String[0]) + "]");
        System.out.println("[" + concatenate(",") + "]");
    }

    static String concatenate(String delim, String... args) {
        String result = "";

        for (String str : args) {
            result += str + delim;
        }

        return result;
    }

    // 가능하면 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋다.
}
