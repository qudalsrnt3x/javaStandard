package Chapter05.day02;

public class ArrayEx12 {
    public static void main(String[] args) {
        String[] names = {"Kim", "Park", "Yi"};

        for (int i = 0; i < names.length; i++) {
            System.out.println("name[" + i + "]:" + names[i]);
        }

        String tmp = names[2]; // 배열의 3번째 요소를 tmp에 저장
        System.out.println("tmp = " + tmp);
        names[0] = "Yu"; // 배열 names의 첫 번째 요소를 "Yu"로 변경

        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
