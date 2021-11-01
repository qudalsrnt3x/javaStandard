package Chapter11.day25;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");    // key값이 중복되면 기존 value는 덮어씌어진다.

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요");
            System.out.print("id : ");
            String id = sc.nextLine().trim(); // id로 입력한 값을 String id 변수에 넣어준다.

            System.out.print("password : ");
            String password = sc.nextLine().trim(); // password로 입력한 값을 String password에 넣어준다.
            System.out.println();

            if (!map.containsKey(id)) { // map에 id와 같은 키가 없다면
                System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요.");
                continue;
            } else {
                if (!(map.get(id)).equals(password)) { // map.get(Object key) => key에 해당하는 값(value)을 반환
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                } else {
                    System.out.println("id와 비밀번호가 일치합니다.");
                    break;
                }
            }
        }
    }
}
