package Chapter11.day24;

import java.util.HashSet;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 23));   // 클래스는 중복이어도 둘 다 나온다??
        set.add(new Person("David", 23));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + ": " + age;
    }
}
