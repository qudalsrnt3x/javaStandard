package Chapter11.day25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111");
        addPhoneNo("친구", "강자바", "010-222-1111");
        addPhoneNo("친구", "김자바", "010-333-1111");
        addPhoneNo("회사", "나자바", "010-444-1111");
        addPhoneNo("회사", "문자바", "010-115-1111");
        addPhoneNo("회사", "오자바", "010-116-1111");
        addPhoneNo("회사", "차자바", "010-117-1111");
        addPhoneNo("세탁", "010-888-8888");

        printList();
    }

    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(tel, name); // 이름은 중복될 수 있으니 전화번호를 key로 지정한다.
    }

    static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {    // 없으면
            phoneBook.put(groupName, new HashMap<>());  // groupName을 key값에 HashMap을 value에 넣어준다.
        }
    }

    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    static void printList() {
        Set set = phoneBook.entrySet(); // key와 value값을 Set형식으로 반환
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();

            Set subSet = ((HashMap) e.getValue()).entrySet(); // set에 저장된 value 값이 HashMap 형태기 때문에 한 번더 set으로 key, value값을 반환
            Iterator subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]"); // e.getkey -> groupName , subSet의 size()를 통해 value의 갯수 반환

            while (subIt.hasNext()) {
                Map.Entry subE = (Map.Entry) subIt.next();
                String telNo = (String) subE.getKey();
                String name = (String) subE.getValue();
                System.out.println(name + " " + telNo);
            }
            System.out.println();
        }
    }
}

