package Chapter12.day29;

import java.util.ArrayList;

class NewClass2 {
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

public class AnnotationEx3 {
    @SuppressWarnings("deprecation")    // deprecation 관련 경고를 억제
    public static void main(String[] args) {
        NewClass2 nc = new NewClass2();

        nc.oldField = 10;                       // @Deprecated 가 붙은 대상을 사용
        System.out.println(nc.getOldField());   // @Deprecated 가 붙은 대상을 사용

        @SuppressWarnings("unchecked")  // 제네릭스 관련 경고를 억제
        ArrayList<NewClass2> list = new ArrayList<>();
        list.add(nc);

    }
}
