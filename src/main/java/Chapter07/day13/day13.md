### 💡Day 13 제어자(modifier)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️제어자란?

> 제어자는 클래스, 변수 또는 메서드의 선언부에 함께 사용되어 부가적인 의미를 부여한다.
>
> **접근 제어자** public, protected, default, private<br>
> **그 외** static, final, abstract, native, transient, synchronized, volatile, strictfp


<br>

### ✏️static - 클래스의, 공통적인

> static변수는 인스턴스에 관계없이 같은 값을 갖는다.

```java
class StaticTest {
    static int width = 200;
    static int height = 120;
    
    static { // 클래스 초기화 블럭
    	// static변수의 복잡한 초기화 수행
    }
    // 주로 클래스변수를 초기화하는데 주로 사용된다.
    
    static int max(int a, int b) { // 클래스 메서드(static메서드)
        return a > b ? a : b;
    }
}
```
#### 대상
- 멤버변수<br>
  `모든 인스턴스에 공통적으로 사용되는 클래스변수가 된다.`<br>
  `클래스변수는 인스턴스를 생성하지 않고도 사용 가능하다.`<br>
  `클래스가 메모리에 로드될 때 생성된다.`

- 메서드<br>
  `인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.`<br>
  `static 메서드 내에서는 인스턴스멤버들을 직접 사용할 수 없다.`

### ✏️final - 마지막의, 변경될 수 없는

> 변수, 메서드, 클래스에 사용 가능하며 값이나 확장을 할 수 없게 한다.

```java
final class FinalTest {  // 조상이 될 수 없는 클래스
    final int MAX_SIZE = 10; // 값을 변경할 수 없는 멤버변수(상수)
    
    final void getMaxSize() { // 오버라이딩 할 수 없는 메서드
        final int LV = MAX_SIZE; // 값을 변경할 수 없는 지역변수(상수)
        return MAX_SIZE;
    }
}
```
#### 대상
- 클래스<br>
  `변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다. 다른 클래스의 조상이 될 수 없다.`
<br>
<br>
- 메서드<br>
  `변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.`
  <br>
  <br>
- 멤버변수, 지역변수<br>
  `변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.`

#### 생성자를 이용한 final멤버변수의 초기화

final이 붙은 변수는 상수이므로 일반적으로 선언과 초기화를 동시에 하지만, 인스턴스 변수의 경우 생성자에서 초기화 되도록 할 수 있다.

이것을 활용하여 클래스 내에서 매개변수를 갖는 생성자를 선언하여, 인스턴스를 생성할 때 final이 붙은 멤버변수를 초기화하는데 필요한 값을 매개변수로부터 제공받는다.

>일단 생성되면 멤버변수 값이 변경되면 안될 때 사용한다.

### ✏️abstract - 추상의, 미완성의

> 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는데 사용된다.

```java
abstract class AbstractTest { // 추상 클래스(추상 메서드를 포함하는 클래스)
    abstract void move(); // 추상 메서드(구현부가 없는 메서드)
}
```

#### 대상

- 클래스<Br>
  `클래스 내에 추상 메서드가 선언되어 있음을 의미`
  <br>
  <br>
- 메서드<br>
  `선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다.`

### ✏️접근 제어자(access modifier)

> public > protected > (default) > private

#### 접근 제어자를 이용한 캡슐화

데이터를 외부에서 함부로 변경하지 못하도록 하기 위해서는 외부로부터의 접근을 제한하는 것이 필요하다.


접근 제어자를 통해 적절하게 접근 범위를 최소화할 수 있다.
`getter, setter`

#### 생성자의 접근 제어자

생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있다. 보통 생성자의 접근 제어자는 클래스의 접근 제어자와 같지만, 다르게 지정할 수 있다.

```java
class Singleton {
    private Singleton() { // 외부에서 인스턴스 생성 불가, 클래스 내부에서 인스턴스 생성
       ...
    }
    ...
}
```

### ✏️제어자의 조합

1. 메서드에 static과 abstract를 함께 사용할 수 없다.
2. 클래스에 abstract와 final을 동시에 사용할 수 없다.
3. abstract메서드의 접근 제어자가 private일 수 없다.
4. 메서드에 private과 final을 같이 사용할 필요는 없다.

