package Chapter11.day24;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetEx4 {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 23)); // HashCode와 Equals 도 오버라이드 해준다.
        set.add(new Person2("David", 23));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
