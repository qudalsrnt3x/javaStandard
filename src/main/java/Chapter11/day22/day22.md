### 💡Day 22 컬렉션 프레임워크(Collection Framework)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard


### ✏️컬렉션 프레임워크란?
-  다수의 데이터를 다루기 위한 자료구조를 표현하고 사용하는 클래스의 집합
- 컬렉션 프레임워크의 모든 클래스는 Collection interface를 구현(implement)하는 클래스 또는 인터페이스


#### 컬렉션 프레임워크의 핵심 인터페이스

`Collection` 은 모든 자료구조가 구현(implement)하는 인터페이스입니다. 아래 배우는 모든 자료구조에 해당하는 클래스, 인터페이스는 언제나 `Collection` 인터페이스를 구현하고 있습니다.

1. **List** : 순서가 있는 데이터의 집합이며 데이터의 중복을 허용합니다.
   → ArrayList, LinkedList, Stack 등
2. **Set** : 순서를 유지하지 않는 데이터의 집합이며 데이터의 중복을 허용하지 않습니다.
   → HashSet, TreeSet 등
3. **Map** : 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합입니다. 순서는 유지되지 않으며 키는 중복을 허용되지 않고 값은 중복을 허용합니다.
   → HashMap, TreeMap 등

<br>

### ArrayList
> 기존의 Vector를 개선한 것, 배열을 이용해서 데이터를 순차적으로 저장

- 배열을 이용하기 때문에 저장, 조회에는 용이하나 용량을 변경하면 새로운 배열을 생성해야돼서 효율성이 떨어짐

- 배열의 중간에 위치한 객체를 추가하거나 삭제하는 경우 `System.arraycopy()`를 호출해서 다른 데이터의 위치를 이동시켜 줘야 하기 때문에 작업시간이 오래걸린다.

<br>

### LinkedList
> 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태로 구성

- 링크드리스트의 각 요소(node)들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성

- 링크드리스트는 이동방향이 단방향이기 때문에, 다음 요소에대한 접근은 쉽지만 이전 요소에 대한 접근은 어려움 -> 이를 보완한 것이 <strong>더블링크드리스트</strong>

<br>

### ArrayList와 LinkedList 비교

```java
package Chapter11.day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
    public static void main(String[] args) {

        // 추가할 데이터의 개수를 고려하여 충분히 잡아야한다.
        ArrayList al = new ArrayList(2000000);
        LinkedList ll = new LinkedList();

        System.out.println("= 순차적으로 추가하기 =");
        System.out.println("ArrayList: "+add1(al));
        System.out.println("LinkedList: "+add1(ll));
        System.out.println();
        System.out.println("= 중간에 추가하기 =");
        System.out.println("ArrayList: "+add2(al));
        System.out.println("LinkedList: "+add2(ll));
        System.out.println();
        System.out.println("= 중간에서 삭제하기 =");
        System.out.println("ArrayList: "+remove2(al));
        System.out.println("LinkedList: "+remove2(ll));
        System.out.println();
        System.out.println("= 순차적으로 삭제하기 =");
        System.out.println("ArrayList: "+remove1(al));
        System.out.println("LinkedList: "+remove1(ll));
        System.out.println();
    }

    public static long add1(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) list.add(i+"");
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long add2(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) list.add(500+"X");
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove1(List list) {
        long start = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove2(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}

```
실행결과

```
= 순차적으로 추가하기 =
ArrayList: 119
LinkedList: 160

= 중간에 추가하기 =
ArrayList: 16
LinkedList: 161

= 중간에서 삭제하기 =
ArrayList: 5859
LinkedList: 289

= 순차적으로 삭제하기 =
ArrayList: 17
LinkedList: 45
```

> 결론1 순차적으로 추가/삭제하는 경우에는 ArrayList가 빠름<br>
결론2 중간 데이터를 추가/삭제하는 경우에는 LinkedList가 빠름

|컬렉션|읽기(접근시간)|추가 / 삭제|비 고|
|------|-------|------|-------|
|ArrayList|빠르다|느리다|순차적인 추가삭제는 더 빠름. 비효율적인 메모리 사용|
|LinkedList|느리다|빠르다|데이터가 많을수록 접근성이 떨어짐|

