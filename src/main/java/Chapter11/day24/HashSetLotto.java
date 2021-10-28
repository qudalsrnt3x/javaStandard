package Chapter11.day24;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }

        List list = new LinkedList(set);        // Collections.sort (List list)사용하기 위해 LinkedList(Set set) 객체 만들어줌
        Collections.sort(list);
        System.out.println(list);
    }
}
