package Chapter12.day29;

class NewClass {
    int newField;

    int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {
        return oldField;
    }
}

public class AnnotationEx2 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;                       // @Deprecated 옵션 붙은 대상을 사용
        System.out.println(nc.getOldField());   // @Deprecated 옵션 붙은 대상을 사용

    }
}
