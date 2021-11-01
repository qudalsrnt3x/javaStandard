package Chapter11.day25;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바", 100);
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        Set set = map.entrySet();   // HashMap에 저장된 키와 값을 Entry(키와 값으 결합)형태로 Set에 저장해서 반환
        Iterator it = set.iterator();   // Iterator 인터페이스를 통해 저장된 요소 가져오기

        while (it.hasNext()) {  // 커서 돌면서 다음 값이 있으면
            Map.Entry e = (Map.Entry) it.next();    // Map.Entry 를 통해 키와 값을 따로 가져올 수도 있다.
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float) total / set.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));
    }
}
