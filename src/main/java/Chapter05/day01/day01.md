### 💡Day 01 배열(array)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.

<br>

### ✏️배열이란?

>같은 타입의 여러 변수를 하나의 묶음으로 다루는 것

![](https://images.velog.io/images/qudalsrnt3x/post/9225c88e-f130-417a-9c47-0cd71f924f7e/image.png)

- 배열은 각 저장공간이 연속적으로 배치되어있다.
- `인덱스(index)`의 범위는 0부터 **'배열길이 -1'**까지.

#### 배열의 생성

배열을 선언한 다음에는 배열을 생성해야한다. 배열을 선언하는 것은 생성된 배열을 다루기 위한 참조변수를 위한 공간이 만들어질 뿐이다. 배열을 생성해야 값을 저장할 수 있는 공간이 만들어지는 것이다.
```java
타입[ ] 변수이름;
변수이름 = new 타입[길이];

// 한 줄로 선언 가능
타입[] 변수이름 = new 타입[길이];
```

#### 배열의 인덱스
- 생성된 배열의 각 저장공간을 배열의 요소(element)라고 하며,
- 배열이름[인덱스]형식으로 배열의 요소에 접근한다. 
- `인덱스(index)`는 배열의 요소마다 붙여진 일련번호로 각 요소를 구별하는데 사용된다.

```java
score[0] = 0;
score[1] = 10;
score[2] = 20;
score[3] = 30;
score[4] = 40;
```

#### 배열의 길이

배열의 길이는 배열의 요소의 개수, 즉 값을 저장할 수 있는 공간의 개수이다. 배열의 길이는 양의 정수이어야 하며 최대값은 int타입의 최대값, 약 20억이다. 배열 길이가 0일 수도 있다.
- 배열의 길이는 int 범위의 양의 정수(0 포함)이어야 한다.
```java
배열이름.length 로 표현가능
```

#### 배열의 복사

배열은 한 번 생성하면 길이를 변경할 수 없기 때문에 더 많은 저장공간이 필요하다면 보다 큰 배열을 새로 만들고 이전 배열로부터 내용을 복사해야한다.

- for문 사용
```java
 int[] arr = new int[5];
 ...
 // 새로운 배열 생성 ( 기존 arr의 길이 2배)
 int[] tmp = new int[arr.length * 2];

 // 배열 arr에 저장된 값들을 배열 tmp에 복사한다.
 for (int i = 0; i < arr.length; i++) {
     tmp[i] = arr[i];
 }

 arr = tmp;
```

- System.arraycopy()를 이용한 배열의 복사
```java
char[] abc = {'A', 'B', 'C', 'D'};
char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

// char 배열은 for문을 쓰지 않아도 값이 붙여서 출력된다.
System.out.println(abc);
System.out.println(num);

// 배열 abc와 num을 붙여서 하나의 배열 (result)로 만든다.
char[] result = new char[abc.length + num.length];
System.arraycopy(abc, 0, result, 0, abc.length);
System.arraycopy(num, 0, result, abc.length, num.length);
```
<br>

### ✏️배열의 활용

- 섞기(shuffle)

```java
public class ArrayEx7 {
    public static void main(String[] args) {
        // 섞기(shuffle)

        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i; // 배열을 0~9까지 초기화
            System.out.print(numArr[i]);
        }

        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10); // 0~9 중의 한 값을 임의로 얻는다.

            int tmp = numArr[0]; // tmp 에 numArr[0] 값을 넣어준다.
            numArr[0] = numArr[n]; // numArr[0]에 numArr[n] 의 값을 넣어준다.
            numArr[n] = tmp;    // numArr[n]에 tmp (numArr[0])값을 넣어준다.
        }

        // 배열 출력
        System.out.println(Arrays.toString(numArr));
    }
}
```
- 버블정렬

```java
public class ArrayEx10 {
    public static void main(String[] args) {

        // 정렬하기(sort)

        int[] numArr = new int[10]; // 10개의 정수를 저장할 배열 생성

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] = (int) (Math.random() * 10)); // 0~9까지의 임의의 값 넣기
        }
        System.out.println();

        for (int i = 0; i < numArr.length - 1; i++) { // 배열의 길이 - 1번 만큼 반복
            boolean changed = false; // 자리바꿈이 발생했는지 체크한다.

            for (int j = 0; j < numArr.length - 1 - i; j++) { // i가 커질수록 비교횟수는 하나씩 줄어든다.
                if (numArr[j] > numArr[j + 1]) {// 옆의 값이 작으면 서로 바꾼다.

                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                    changed = true; // 자리바꿈이 발생했으니 true로 변경
                }
            }

            if(!changed) break; // 자리바꿈이 없으면 반복문을 벗어난다.

            for (int k = 0; k < numArr.length; k++) {
                System.out.print(numArr[k]); // 정렬된 결과를 출력한다.
            }
            System.out.println();
        }
    }
}
```

- 빈도 수 구하기

```java
public class ArrayEx11 {
    public static void main(String[] args) {

        // 빈도 수 구하기
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 10); // 0~9까지의 임의의 수를 배열에 저장
            System.out.print(numArr[i]);
        }
        System.out.println();

        for (int i = 0; i < numArr.length; i++) {
            counter[numArr[i]]++;
        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.println(i + "의 개수 : " + counter[i]);
        }
    }
}
```
