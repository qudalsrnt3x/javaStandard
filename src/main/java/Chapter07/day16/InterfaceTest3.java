package Chapter07.day16;

class AAA {
    void autoPlay(II i) {
        i.play();
    }
}

interface II {
    public abstract void play();
}

class BBB implements II {
    @Override
    public void play() {
        System.out.println("play in BBB class");
    }
}

class CCC implements II {
    @Override
    public void play() {
        System.out.println("play in CCC class");
    }
}

public class InterfaceTest3 {
    public static void main(String[] args) {
        AAA a = new AAA();
        a.autoPlay(new BBB()); // void autoPlay(II i) 호출
        a.autoPlay(new CCC()); // void autoPlay(II i) 호출

    }

}
