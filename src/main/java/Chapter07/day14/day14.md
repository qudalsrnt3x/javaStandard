### 💡Day 14 다형성(polymorphism)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️다형성이란?
> 여러가지 형태를 가질 수 있는 능력, 조상 클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 구현한 것

```java
class Tv {
    ...
}

class CaptionTv extends Tv {
    ...
}
```
- 지금까지 우리는 생성된 인스턴스를 다루기 위해서, 인스턴스의 타입과 일치하는 타입의 참조변수만 사용했다.
```java
Tv t = new Tv();
CaptionTv c = new CaptionTv();
```

- Tv와 CaptionTv클래스가 서로 상속관계에 있을 경우, 다음과 같이 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하도록 하는 것이 가능
```java
Tv t = new CaptionTv();
```

#### 어떤 차이가 있는가?
```java
Tv t = new CaptionTv(); // 조상 클래스의 멤버만 사용가능
CaptionTv c = new CaptionTv(); // 자손 클래스의 멤버까지 사용가능
```
- 둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버의 갯수가 달라진다.

#### 반대로는 불가
```java
CaptionTv c = new Tv();
```

- 실제 인스턴스인 Tv의 멤버 개수보다 참조변수 c가 사용할 수 있는 멤버 개수가 더 많기 때문이다.

> 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있다.<br>
> 반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수는 없다.

<br>

### ✏️참조변수의 형변환

서로 상속관계에 있는 클래스 사이에서만 형변환이 가능하다.
> 자손타입 -> 조상타입 (Up-casting) : 형변환 생략가능<br>
> 조상타입 -> 자손타입 (Down-casting) : 형변환 생략불가

#### 형변환을 생략할 수 있는 경우, 없는 경우
```java
class Car {
    ...
}

class FireEngine extends Car { // 소방차
    ...
}

class Ambulance extends Car { // 앰뷸런스
    ...
}
```

```java
Car car = null;
FireEngine fe = new FireEngine();
FireEngine fe2 = null;

car = fe;	// car = (car)fe; 자손에서 상위 클래스로 캐스팅하는 것이므로 생략가능
fe2 = (FireEngine)car;	// 형변환을 생략불가. 다운캐스팅
```

Car타입의 참조변수 car를 자손인 FireEngine타입으로 변환하는 것은 참조변수가 다룰 수 있는 멤버의 개수를 늘이는 것이므로, 실제 인스턴스의 멤버 개수보다 참조변수가 사용할 수 있는 멤버의 개수가 더 많아지므로 문제가 발생할 수 있다.

> 형변환은 참조변수의 타입을 변환하는 것뿐, 인스턴스를 변환하는 것은 아니다.<br>
> 단지 참조변수의 형변환을 통해서, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위(개수)를 조절하는 것뿐이다.

#### 형변환 오류 예시
```java
Car car = new Car();
FireEngine fe = null;

fe = (FireEngine)car; // 컴파일은 OK, 실행 시 에러가 발생한다.
```
Car타입의 참조변수 car가 이미 Car인스턴스를 참조하고 있기 때문에 조상타입의 인스턴스를 자손타입인 FireEngine 인스턴스로 변경할 시 에러가 발생하는 것이다.

<br>

### ✏️instanceof연산자
> 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof연산자를 사용한다.

```java
public class InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();

        if (fe instanceof FireEngine) {
            System.out.println("This is a FireEngine instance.");
        }

        if (fe instanceof Car) {
            System.out.println("This is a Car instance");
        }

        if (fe instanceof Object) {
            System.out.println("This is an Object instance");
        }

        System.out.println(fe.getClass().getName()); // 클래스의 이름을 출력

    }
}
```
실행결과
```
This is a FireEngine instance.
This is a Car instance
This is an Object instance
Chapter07.day14.FireEngine
```
- 생성된 인스턴스는 FireEngine타입인데도, Object타입과 Car타입의 instanceof연산자에서도 ture	결과로 나온다.
- 그 이유는 조상의 멤버들을 상속받았기 때문에, FireEngine인스턴스는 Object인스턴스와 Car인스턴스를 포함하고 있는 셈이다.

> 어떤 타입에 대한 instanceof연산의 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.

#### 참조변수와 인스턴스의 연결

> 조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스변수를 자손 클래스에서 중복으로 정의했을 때, 멤버변수의 경우 참조변수의 타입에 따라 값이 달라진다.

```java
public class BindingTest {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        System.out.println("p.x = " + p.x); // 참조변수의 타입에 따라서 멤버변수 호출 값이 달라진다.
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    int x = 200;

    void method() {
        System.out.println("Chile Method");
    }
}
```
실행결과
```
p.x = 100
Parent Method
c.x = 200
Chile Method
```

