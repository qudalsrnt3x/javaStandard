package Chapter11.day24;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZZ");
        set.add("dzzzz");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search: from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to)); // 범위 검색, 끝번호는 포함되지 않음
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));
    }
}
