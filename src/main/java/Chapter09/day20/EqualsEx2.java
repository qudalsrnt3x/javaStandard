package Chapter09.day20;

import java.util.Objects;

class Person {
    long id;

    public boolean equals(Object obj) { // 멤버변수의 id값을 비교하기 위해서 오버라이드
        if(obj instanceof Person)
            return id == ((Person)obj).id;
        else
            return false;
    } 
    

    Person(long id) {
        this.id = id;
    }
}

public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(80808080L);
        Person p2 = new Person(80808080L);

        if (p1 == p2) { // 객체의 주소값을 비교
            System.out.println("p1과 p2는 같은 사람입니다");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다.");
        }

        if(p1.equals(p2))
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");


    }
}
