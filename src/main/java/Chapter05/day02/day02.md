### 💡Day 02 String배열
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

### ✏️String배열

#### String배열의 선언과 생성
```java
String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열 생성
```

참조형 변수의 기본값은 null이므로 각 요소의 값은 null로 초기화 된다.

|자료형|기본값|
|------|:---:|
|boolean|false|
|char|'\u0000'|
|byte, short, int|0|
|long|0L|
|float|0.0f|
|double|0,0d 또는 0.0|
|참조형 변수|null|

#### String배열의 초기화

```java
String[] name = new String[3];
name[0] = "Kim";
name[1] = "Park";
name[2] = "Yu";

또는

String[] name = new String[]{"Kim", "Park", "Yu"};
String[] name =  {"Kim", "Park", "Yu"};
```

-  참조형 배열의 경우 배열에 저장되는 것은 **객체의 주소**이다.

### ✏️char배열과 String클래스

> String클래스는 char배열에 기능(메서드)을 추가한 것이다.


#### char배열과 String클래스의 변환
다음의 코드를 사용
```java
char[] chArr = {'A', 'B', 'C'};
String str = new String(chArr); // char배열 -> String배열
char[] tmp = str.toCharArray(); // String배열 -> char배열
```

예제
```java
public class ArrayEx14 {
    public static void main(String[] args) {
        // char배열과 String클래스의 변환

        String src = "ABCDE";

        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);  // src의 i번째 문자를 ch에 저장
            System.out.println("ch = " + ch);
        }

        // String을 char[] 로 변환
        char[] chArr = src.toCharArray();

        // char배열 출력
        System.out.println(chArr);
        
    }
}

```