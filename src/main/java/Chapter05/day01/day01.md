### π‘Day 01 λ°°μ΄(array)
> μ΄ κΈμ λ¨κΆμ±λμ μλ°μ μ μ 3/eλ₯Ό κΈ°λ°μΌλ‘ κ³΅λΆν λ΄μ©μ μ λ¦¬ν κΈμλλ€.

<br>

### βοΈλ°°μ΄μ΄λ?

>κ°μ νμμ μ¬λ¬ λ³μλ₯Ό νλμ λ¬ΆμμΌλ‘ λ€λ£¨λ κ²

![](https://images.velog.io/images/qudalsrnt3x/post/9225c88e-f130-417a-9c47-0cd71f924f7e/image.png)

- λ°°μ΄μ κ° μ μ₯κ³΅κ°μ΄ μ°μμ μΌλ‘ λ°°μΉλμ΄μλ€.
- `μΈλ±μ€(index)`μ λ²μλ 0λΆν° **'λ°°μ΄κΈΈμ΄ -1'**κΉμ§.

#### λ°°μ΄μ μμ±

λ°°μ΄μ μ μΈν λ€μμλ λ°°μ΄μ μμ±ν΄μΌνλ€. λ°°μ΄μ μ μΈνλ κ²μ μμ±λ λ°°μ΄μ λ€λ£¨κΈ° μν μ°Έμ‘°λ³μλ₯Ό μν κ³΅κ°μ΄ λ§λ€μ΄μ§ λΏμ΄λ€. λ°°μ΄μ μμ±ν΄μΌ κ°μ μ μ₯ν  μ μλ κ³΅κ°μ΄ λ§λ€μ΄μ§λ κ²μ΄λ€.
```java
νμ[ ] λ³μμ΄λ¦;
λ³μμ΄λ¦ = new νμ[κΈΈμ΄];

// ν μ€λ‘ μ μΈ κ°λ₯
νμ[] λ³μμ΄λ¦ = new νμ[κΈΈμ΄];
```

#### λ°°μ΄μ μΈλ±μ€
- μμ±λ λ°°μ΄μ κ° μ μ₯κ³΅κ°μ λ°°μ΄μ μμ(element)λΌκ³  νλ©°,
- λ°°μ΄μ΄λ¦[μΈλ±μ€]νμμΌλ‘ λ°°μ΄μ μμμ μ κ·Όνλ€. 
- `μΈλ±μ€(index)`λ λ°°μ΄μ μμλ§λ€ λΆμ¬μ§ μΌλ ¨λ²νΈλ‘ κ° μμλ₯Ό κ΅¬λ³νλλ° μ¬μ©λλ€.

```java
score[0] = 0;
score[1] = 10;
score[2] = 20;
score[3] = 30;
score[4] = 40;
```

#### λ°°μ΄μ κΈΈμ΄

λ°°μ΄μ κΈΈμ΄λ λ°°μ΄μ μμμ κ°μ, μ¦ κ°μ μ μ₯ν  μ μλ κ³΅κ°μ κ°μμ΄λ€. λ°°μ΄μ κΈΈμ΄λ μμ μ μμ΄μ΄μΌ νλ©° μ΅λκ°μ intνμμ μ΅λκ°, μ½ 20μ΅μ΄λ€. λ°°μ΄ κΈΈμ΄κ° 0μΌ μλ μλ€.
- λ°°μ΄μ κΈΈμ΄λ int λ²μμ μμ μ μ(0 ν¬ν¨)μ΄μ΄μΌ νλ€.
```java
λ°°μ΄μ΄λ¦.length λ‘ ννκ°λ₯
```

#### λ°°μ΄μ λ³΅μ¬

λ°°μ΄μ ν λ² μμ±νλ©΄ κΈΈμ΄λ₯Ό λ³κ²½ν  μ μκΈ° λλ¬Έμ λ λ§μ μ μ₯κ³΅κ°μ΄ νμνλ€λ©΄ λ³΄λ€ ν° λ°°μ΄μ μλ‘ λ§λ€κ³  μ΄μ  λ°°μ΄λ‘λΆν° λ΄μ©μ λ³΅μ¬ν΄μΌνλ€.

- forλ¬Έ μ¬μ©
```java
 int[] arr = new int[5];
 ...
 // μλ‘μ΄ λ°°μ΄ μμ± ( κΈ°μ‘΄ arrμ κΈΈμ΄ 2λ°°)
 int[] tmp = new int[arr.length * 2];

 // λ°°μ΄ arrμ μ μ₯λ κ°λ€μ λ°°μ΄ tmpμ λ³΅μ¬νλ€.
 for (int i = 0; i < arr.length; i++) {
     tmp[i] = arr[i];
 }

 arr = tmp;
```

- System.arraycopy()λ₯Ό μ΄μ©ν λ°°μ΄μ λ³΅μ¬
```java
char[] abc = {'A', 'B', 'C', 'D'};
char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

// char λ°°μ΄μ forλ¬Έμ μ°μ§ μμλ κ°μ΄ λΆμ¬μ μΆλ ₯λλ€.
System.out.println(abc);
System.out.println(num);

// λ°°μ΄ abcμ numμ λΆμ¬μ νλμ λ°°μ΄ (result)λ‘ λ§λ λ€.
char[] result = new char[abc.length + num.length];
System.arraycopy(abc, 0, result, 0, abc.length);
System.arraycopy(num, 0, result, abc.length, num.length);
```
<br>

### βοΈλ°°μ΄μ νμ©

- μκΈ°(shuffle)

```java
public class ArrayEx7 {
    public static void main(String[] args) {
        // μκΈ°(shuffle)

        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i; // λ°°μ΄μ 0~9κΉμ§ μ΄κΈ°ν
            System.out.print(numArr[i]);
        }

        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10); // 0~9 μ€μ ν κ°μ μμλ‘ μ»λλ€.

            int tmp = numArr[0]; // tmp μ numArr[0] κ°μ λ£μ΄μ€λ€.
            numArr[0] = numArr[n]; // numArr[0]μ numArr[n] μ κ°μ λ£μ΄μ€λ€.
            numArr[n] = tmp;    // numArr[n]μ tmp (numArr[0])κ°μ λ£μ΄μ€λ€.
        }

        // λ°°μ΄ μΆλ ₯
        System.out.println(Arrays.toString(numArr));
    }
}
```
- λ²λΈμ λ ¬

```java
public class ArrayEx10 {
    public static void main(String[] args) {

        // μ λ ¬νκΈ°(sort)

        int[] numArr = new int[10]; // 10κ°μ μ μλ₯Ό μ μ₯ν  λ°°μ΄ μμ±

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] = (int) (Math.random() * 10)); // 0~9κΉμ§μ μμμ κ° λ£κΈ°
        }
        System.out.println();

        for (int i = 0; i < numArr.length - 1; i++) { // λ°°μ΄μ κΈΈμ΄ - 1λ² λ§νΌ λ°λ³΅
            boolean changed = false; // μλ¦¬λ°κΏμ΄ λ°μνλμ§ μ²΄ν¬νλ€.

            for (int j = 0; j < numArr.length - 1 - i; j++) { // iκ° μ»€μ§μλ‘ λΉκ΅νμλ νλμ© μ€μ΄λ λ€.
                if (numArr[j] > numArr[j + 1]) {// μμ κ°μ΄ μμΌλ©΄ μλ‘ λ°κΎΌλ€.

                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                    changed = true; // μλ¦¬λ°κΏμ΄ λ°μνμΌλ trueλ‘ λ³κ²½
                }
            }

            if(!changed) break; // μλ¦¬λ°κΏμ΄ μμΌλ©΄ λ°λ³΅λ¬Έμ λ²μ΄λλ€.

            for (int k = 0; k < numArr.length; k++) {
                System.out.print(numArr[k]); // μ λ ¬λ κ²°κ³Όλ₯Ό μΆλ ₯νλ€.
            }
            System.out.println();
        }
    }
}
```

- λΉλ μ κ΅¬νκΈ°

```java
public class ArrayEx11 {
    public static void main(String[] args) {

        // λΉλ μ κ΅¬νκΈ°
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 10); // 0~9κΉμ§μ μμμ μλ₯Ό λ°°μ΄μ μ μ₯
            System.out.print(numArr[i]);
        }
        System.out.println();

        for (int i = 0; i < numArr.length; i++) {
            counter[numArr[i]]++;
        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.println(i + "μ κ°μ : " + counter[i]);
        }
    }
}
```
