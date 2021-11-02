package Chapter12.day27;

import java.util.ArrayList;

class Fruit3 {
    @Override
    public String toString() {
        return "Fruit3";
    }
}

class Apple3 extends Fruit3 {
    @Override
    public String toString() {
        return "Apple3";
    }
}

class Grape3 extends Fruit3 {
    @Override
    public String toString() {
        return "Grape3";
    }
}

class Juice {
    String name;

    Juice(String name) {
        this.name = name + " Juice";
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox3<? extends Fruit3> box) {
        StringBuilder tmp = new StringBuilder();

        for (Fruit3 fruit : box.getList()) {
            tmp.append(fruit).append(" ");
        }
        return new Juice(tmp.toString());
    }
}

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox3<Fruit3> fruitBox = new FruitBox3<>();
        FruitBox3<Apple3> appleBox = new FruitBox3<>();

        fruitBox.add(new Apple3());
        fruitBox.add(new Grape3());
        appleBox.add(new Apple3());
        appleBox.add(new Apple3());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));

    }

}

class FruitBox3<T extends Fruit3> extends Box3<T>{}

class Box3<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int index) {
        return list.get(index);
    }

    ArrayList<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}