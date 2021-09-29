package Chapter07.day16;

class AA {
    public void methodBB(I i) {
        i.methodB();
    }
}

interface I {
    void methodB();
}

class BB implements I{

    @Override
    public void methodB() {
        System.out.println("methodB()");
    }
}


public class InterfaceTest2 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.methodBB(new BB());
    }
}
