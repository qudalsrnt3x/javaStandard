### 💡Day 18 예외처리(exception handling)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️프로그램 오류

개발에 있어서 오류가 나는 것은 당연한 일이다. 오류가 나기 때문에 무엇이 잘못되었는지 확인 할 수 있다.

프로그램 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우가 있다. 이러한 결과를 초래하는 원인을 프로그램 에러 또는 오류라고 한다.

> **컴파일에러** 컴파일 시에 발생하는 에러
> **런타임에러** 실행 시에 발생하는 에러
> **논리적에러** 실행은 되지만, 의도와 다르게 동작하는 것

자바에서 문법에 맞지 않게 작성된 코드는 사전에 컴파일러에 의해 컴파일 오류(compile time error)로 걸러지지만, 예외는 컴파일은 잘 되지만 실행 중에 발생하게 된다.

#### 예외 클래스 계층구조
![](https://images.velog.io/images/qudalsrnt3x/post/d2792256-c2c8-46de-8caa-c5b8cdc3274d/image.png)

- Exception클래스와 그 자손들 (Check Exceptions) - 컴파일러가 예외처리 확인<br>
  `사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외`

- RuntimeException과 그 자손들 (Unckeck Exceptions) - 컴파일러가 예외처리 확인 X<br>
  `주로 프로그래머의 실수에 의해서 발생하는 예외`


### ✏️예외 처리

> 예외처리란, 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것
목적은 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것

#### try-catch문

- try블럭 내에서 예외가 발생한 경우,
1. 발생한 예외와 일치하는 catch블럭이 있는지 확인
2. 일치하는 catch블럭이 있으면, 그 catch블럭 내의 문장을 수행하고 catch문을 빠져나가서 그 다음 문장을 계속 수행. 만일 일치하는 catch문을 찾지 못하면 예외는 처리되지 못한다.

```java
public class ExceptionEx5 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4); // 실행되지 않는다.
            // try블럭에서 예외가 발생하면, 예외가 발생한 위치 이후에 있는 try블럭의 문장들은 수행되지 않는다.
        } catch (ArithmeticException e) {
            System.out.println(5);
        }
        System.out.println(6);
    }
}
```
실행결과
```
1
2
3
5
6
```
<span style="background-color: yellow;">try블럭에 예외가 발생하면, 예외가 발생한 위치 이후에 있는 try블럭의 문장들은 수행되지 않는다.</span>

- try블럭 내에서 예외가 발생하지 않은 경우,
1. catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

```java
public class ExceptionEx4 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(4);

        } catch (Exception e) {
            System.out.println(5); // 실행되지 않는다.
        }

        System.out.println(6);
    }
}
```
실행결과
```
1
2
3
4
6
```
<br>

#### 배열(ArrayIndexOutOfBoundsException)의 예외처리

```java
public class Main {
	public static void main(String[] args) {
    
    	String[] fruits = {"사과", "배", "포도"};
        
        for(int i=0;i<5, i++)
        	System.out.println(fruits[i]);
	)
}
```
배열의 크기보다 큰 인덱스로 배열의 원소에 접근한 코드이다. 컴파일 시에는 문제가 없지만 실행시켜보면
```java
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	at day18.ExceptionTest1.main(ExceptionTest1.java:13)
```
ArrayIndexOutOfBoundsException 예외가 발생한다.
<br>

- 예외를 처리하기 위해 예외가 발생할 수 있는 코드를 try ~ catch문으로 감싼다.
  catch절의 ()안에는 발생한 예외클래스를 참조하는 매개변수 e를 작성한다.

만약 NullPointException이 발생했다면 catch()절에는 catch(NullPointException e)를 작성한다.

```java
public class Main {
 	public static void main(String[] args) {
          String[] fruits = {"사과", "배", "포도"};

          try {
              for(int i=0;i<5;i++)
                  System.out.println(fruits[i]);
          }catch(ArrayIndexOutOfBoundsException e) {
              // 예외 처리 코드 작성
              System.out.println("배열 인덱스 범위 초과.");
          }

          System.out.println("###반드시 실행되어야 할 코드###");

	}
}
```
실행결과
```
사과
배
포도
배열 인덱스 범위 초과됐어요! 확인해보세요!
###반드시 실행되어야 할 코드###
```

<br>

#### printStackTrace()와 getMessage()

- 예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨 있다.

> **printStackTrace()** 예외발생 당시의 호출스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력
> **getMethod()** 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

```java
public class ExceptionEx8 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4);
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace(); // 참조변수 arithmeticException 인스턴스에 접근할 수 있다.
            System.out.println("예외 메시지 : " + arithmeticException.getMessage());
        }
        System.out.println(6);
    }
}
```
실행결과
```
1
2
3
예외 메시지 : / by zero
java.lang.ArithmeticException: / by zero
	at Chapter08.day18.ExceptionEx8.main(ExceptionEx8.java:10)
6
```

<br>

### ✏️예외 발생시키기

> 1. 먼저, 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음<br>
     `Exception e = new Exception("고의로 발생시켰음");`
> 2. 키워드 throw를 이용해서 예외를 발생시킨다.<br>
     `throw e;`
>
> 한줄로 쓰면 다음과 같다 : `throw new Exception("고의로 발생시켰음");`

---
🚩출처

예외 클래스 계층구조 : https://joswlv.github.io/2018/10/29/java_exception/