package Chapter12.day27;

import java.util.ArrayList;

class Fruit2 implements Eatable {
    @Override
    public String toString() {
        return "Fruit2";
    }
}

class Apple2 extends Fruit2 {
    @Override
    public String toString() {
        return "Apple2";
    }
}

class Grape2 extends Fruit2 {
    @Override
    public String toString() {
        return "Grape2";
    }
}

class Toy2 {
    @Override
    public String toString() {
        return "Toy2";
    }
}

interface Eatable {}

public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit2> fruitBox = new FruitBox<>();
        FruitBox<Apple2> appleBox = new FruitBox<>();
        FruitBox<Grape2> grapeBox = new FruitBox<>();
//        FruitBox<Grape2> grapeBox = new FruitBox<Apple2>();   // 에러. 타입 불일치
//        FruitBox<Toy> toyBox = new FruitBox<Toy>();   // 에러. Toy는 Fruit2의 자손이 아님

        fruitBox.add(new Fruit2());
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
//        appleBox.add(new Grape2());   // 에러. Grape2는 Apple2의 자손이 아님
        grapeBox.add(new Grape2());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

    }
}

class FruitBox<T extends Fruit2 & Eatable> extends Box2<T> {}

class Box2<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
