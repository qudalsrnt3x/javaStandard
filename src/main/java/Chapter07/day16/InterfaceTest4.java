package Chapter07.day16;

public class InterfaceTest4 {
    public static void main(String[] args) {
        AAAA a = new AAAA();
        a.methodA();
    }
}

class AAAA {
    void methodA() {
        III i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}

interface III {
    void methodB();
}

class BBBB implements III {

    public String toString() {
        return "class B";
    }

    @Override
    public void methodB() {
        System.out.println("methodB in BBBB class");
    }
}

class InstanceManager {
    public static III getInstance() {
        return new BBBB();      // 다른 인스턴스를 바꾸려면 여기만 바꾸면 된다.
    }
}
