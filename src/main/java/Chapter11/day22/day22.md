### π‘Day 22 μ»¬λ μ νλ μμν¬(Collection Framework)
> μ΄ κΈμ λ¨κΆμ±λμ μλ°μ μ μ 3/eλ₯Ό κΈ°λ°μΌλ‘ κ³΅λΆν λ΄μ©μ μ λ¦¬ν κΈμλλ€.
>
> **μμ€μ λ¦¬**: https://github.com/qudalsrnt3x/javaStandard


### βοΈμ»¬λ μ νλ μμν¬λ?
-  λ€μμ λ°μ΄ν°λ₯Ό λ€λ£¨κΈ° μν μλ£κ΅¬μ‘°λ₯Ό νννκ³  μ¬μ©νλ ν΄λμ€μ μ§ν©
- μ»¬λ μ νλ μμν¬μ λͺ¨λ  ν΄λμ€λ Collection interfaceλ₯Ό κ΅¬ν(implement)νλ ν΄λμ€ λλ μΈν°νμ΄μ€


#### μ»¬λ μ νλ μμν¬μ ν΅μ¬ μΈν°νμ΄μ€

`Collection` μ λͺ¨λ  μλ£κ΅¬μ‘°κ° κ΅¬ν(implement)νλ μΈν°νμ΄μ€μλλ€. μλ λ°°μ°λ λͺ¨λ  μλ£κ΅¬μ‘°μ ν΄λΉνλ ν΄λμ€, μΈν°νμ΄μ€λ μΈμ λ `Collection` μΈν°νμ΄μ€λ₯Ό κ΅¬ννκ³  μμ΅λλ€.

1. **List** : μμκ° μλ λ°μ΄ν°μ μ§ν©μ΄λ©° λ°μ΄ν°μ μ€λ³΅μ νμ©ν©λλ€.
   β ArrayList, LinkedList, Stack λ±
2. **Set** : μμλ₯Ό μ μ§νμ§ μλ λ°μ΄ν°μ μ§ν©μ΄λ©° λ°μ΄ν°μ μ€λ³΅μ νμ©νμ§ μμ΅λλ€.
   β HashSet, TreeSet λ±
3. **Map** : ν€(key)μ κ°(value)μ μμΌλ‘ μ΄λ£¨μ΄μ§ λ°μ΄ν°μ μ§ν©μλλ€. μμλ μ μ§λμ§ μμΌλ©° ν€λ μ€λ³΅μ νμ©λμ§ μκ³  κ°μ μ€λ³΅μ νμ©ν©λλ€.
   β HashMap, TreeMap λ±

<br>

### ArrayList
> κΈ°μ‘΄μ Vectorλ₯Ό κ°μ ν κ², λ°°μ΄μ μ΄μ©ν΄μ λ°μ΄ν°λ₯Ό μμ°¨μ μΌλ‘ μ μ₯

- λ°°μ΄μ μ΄μ©νκΈ° λλ¬Έμ μ μ₯, μ‘°νμλ μ©μ΄νλ μ©λμ λ³κ²½νλ©΄ μλ‘μ΄ λ°°μ΄μ μμ±ν΄μΌλΌμ ν¨μ¨μ±μ΄ λ¨μ΄μ§

- λ°°μ΄μ μ€κ°μ μμΉν κ°μ²΄λ₯Ό μΆκ°νκ±°λ μ­μ νλ κ²½μ° `System.arraycopy()`λ₯Ό νΈμΆν΄μ λ€λ₯Έ λ°μ΄ν°μ μμΉλ₯Ό μ΄λμμΌ μ€μΌ νκΈ° λλ¬Έμ μμμκ°μ΄ μ€λκ±Έλ¦°λ€.

<br>

### LinkedList
> λΆμ°μμ μΌλ‘ μ‘΄μ¬νλ λ°μ΄ν°λ₯Ό μλ‘ μ°κ²°(link)ν ννλ‘ κ΅¬μ±

- λ§ν¬λλ¦¬μ€νΈμ κ° μμ(node)λ€μ μμ κ³Ό μ°κ²°λ λ€μ μμμ λν μ°Έμ‘°(μ£Όμκ°)μ λ°μ΄ν°λ‘ κ΅¬μ±

- λ§ν¬λλ¦¬μ€νΈλ μ΄λλ°©ν₯μ΄ λ¨λ°©ν₯μ΄κΈ° λλ¬Έμ, λ€μ μμμλν μ κ·Όμ μ½μ§λ§ μ΄μ  μμμ λν μ κ·Όμ μ΄λ €μ -> μ΄λ₯Ό λ³΄μν κ²μ΄ <strong>λλΈλ§ν¬λλ¦¬μ€νΈ</strong>

<br>

### ArrayListμ LinkedList λΉκ΅

```java
package Chapter11.day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
    public static void main(String[] args) {

        // μΆκ°ν  λ°μ΄ν°μ κ°μλ₯Ό κ³ λ €νμ¬ μΆ©λΆν μ‘μμΌνλ€.
        ArrayList al = new ArrayList(2000000);
        LinkedList ll = new LinkedList();

        System.out.println("= μμ°¨μ μΌλ‘ μΆκ°νκΈ° =");
        System.out.println("ArrayList: "+add1(al));
        System.out.println("LinkedList: "+add1(ll));
        System.out.println();
        System.out.println("= μ€κ°μ μΆκ°νκΈ° =");
        System.out.println("ArrayList: "+add2(al));
        System.out.println("LinkedList: "+add2(ll));
        System.out.println();
        System.out.println("= μ€κ°μμ μ­μ νκΈ° =");
        System.out.println("ArrayList: "+remove2(al));
        System.out.println("LinkedList: "+remove2(ll));
        System.out.println();
        System.out.println("= μμ°¨μ μΌλ‘ μ­μ νκΈ° =");
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
μ€νκ²°κ³Ό

```
= μμ°¨μ μΌλ‘ μΆκ°νκΈ° =
ArrayList: 119
LinkedList: 160

= μ€κ°μ μΆκ°νκΈ° =
ArrayList: 16
LinkedList: 161

= μ€κ°μμ μ­μ νκΈ° =
ArrayList: 5859
LinkedList: 289

= μμ°¨μ μΌλ‘ μ­μ νκΈ° =
ArrayList: 17
LinkedList: 45
```

> κ²°λ‘ 1 μμ°¨μ μΌλ‘ μΆκ°/μ­μ νλ κ²½μ°μλ ArrayListκ° λΉ λ¦<br>
κ²°λ‘ 2 μ€κ° λ°μ΄ν°λ₯Ό μΆκ°/μ­μ νλ κ²½μ°μλ LinkedListκ° λΉ λ¦

|μ»¬λ μ|μ½κΈ°(μ κ·Όμκ°)|μΆκ° / μ­μ |λΉ κ³ |
|------|-------|------|-------|
|ArrayList|λΉ λ₯΄λ€|λλ¦¬λ€|μμ°¨μ μΈ μΆκ°μ­μ λ λ λΉ λ¦. λΉν¨μ¨μ μΈ λ©λͺ¨λ¦¬ μ¬μ©|
|LinkedList|λλ¦¬λ€|λΉ λ₯΄λ€|λ°μ΄ν°κ° λ§μμλ‘ μ κ·Όμ±μ΄ λ¨μ΄μ§|

