package Chapter12.day29;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")   // 유요하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "211103", hhmmss = "204434"))
public class AnnotationEx5 {
    public static void main(String[] args) {
        // AnnotationEx5의 Class객체를 얻는다.
        Class<AnnotationEx5> cls = AnnotationEx5.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for (String str : anno.testTools()) {
            System.out.println("testTools = "+ str);
        }

        System.out.println();

        // AnnotationEx5에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation annotation : annoArr) {
            System.out.println(annotation);
        }
    }

}


@Retention(RetentionPolicy.RUNTIME)     // 실행시에도 사용가능
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {
    FIRST,
    FINAL,
}
