package Chapter07.day16;

public class FighterTest {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();

        if (fighter instanceof Unit2)
            System.out.println("f는 Unit클래스의 자손입니다.");

        if (fighter instanceof Fightable)
            System.out.println("f는 Fightable 인터페이스를 구현했습니다.");

        if (fighter instanceof Movable)
            System.out.println("f는 Movable 인터페이스를 구현했습니다.");

        if (fighter instanceof Attackable)
            System.out.println("f는 Attackable 인터페이스를 구현했습니다.");

        if (fighter instanceof Object)
            System.out.println("f는 Object클래스의 자손입니다.");
    }

}

class Fighter extends Unit2 implements Fightable {

    @Override
    public void move(int x, int y) {
        // 내용 생략
    }

    @Override
    public void attack(Unit2 unit) {
        // 내용 생략
    }
}

class Unit2 {
    int currentHP;  // 유닛의 체력
    int x;
    int y;
}

interface Fightable extends Movable, Attackable {
}

interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(Unit2 unit);
}



