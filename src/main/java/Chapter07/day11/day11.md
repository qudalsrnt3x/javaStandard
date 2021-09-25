### 💡Day 11 오버라이딩(overriding)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️오버라이딩이란?
> 자식클래스에서 슈퍼클래스 메서드의 내용만을 새로 작성하는 것


#### 오버라이딩 조건
- 이름이 같아야 한다.
- 매개변수가 같아야 한다.
- 반환타입이 같아야 한다.

조상 클래스의 메서드와 선언부가 일치해야 한다.

#### 단, 접근 제어자(access modifier)와 예외(exception)는 제한된 조건 하에서만 다르게 변경할 수 있다.

- 접근 제어자는 조상 클래스의 메서드보다 좁은 번위로 변경가능
```java
public, protected, (default), private

조상 클래스의 접근 제어자가 protected면
자손 클래스의 접근 제어자는 protected or public이어야 한다.
```
- 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
```java
class Parent {
    void parentMethod() exception IOException, SQLException {
    	...
    }
}

class Child extends Parent {

    @Overriding
    void parentMethod() {
    	...
    }
}
```
> 1. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
> 2. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
> 3. 인스턴스메서드를 static메서드로 또는 그 반대로 변경할 수 없다.

### ✏️오버로딩 vs 오버라이딩

> **오버로딩** 기존에 없는 새로운 메서드를 정의하는 것 (new)
> **오버라이딩** 상속받은 메서드의 내용을 변경하는 것 (change, modify)

```java
class Parent {
    void parentMethod(){}
}

class Child extends Parent {

    void parentMethod(){} // 오버라이딩
    void parentMethod(int i) {} // 오버로딩
}
```

### ✏️super
> 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수

- 조상 클래스로부터 상속받은 멤버도 자손 클래스 자신의 멤버이므로 super대신 this를 사용할 수 있다.
- 조상 클래스의 멤버와 자손클래스의 멤버가 중복 정의되어 서로 구별해야하는 경우에만 super를 사용하는 것이 좋다.

```java
class SuperTest {
    public static void main(String[] args) {
    	Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10;
}

class Child extends Parent {
    void method(){
    	System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}
```
실행결과
```
x = 10
this.x = 10
super.x = 10
```

#### 변수와 메서드 둘 다 super로 호출 가능
```java
class Point {
    int x;
    int y;
    
    String getLocation(){
    	return "x : " + x + ", y : " + y;
    }
}

class Point3D extends Point {
    int z;
    
    @Override
    String getLocation(){
    	return super.getLocation() + ", z : " + z;
        // 부모의 메소드 호출
    }
}
```

#### * static메서드(클래스메서드)는 인스턴스와 관련이 없다. 그래서 this와 마찬가지로 super역시 static메서드에서는 사용할 수 없고 인스턴스메서드에서만 사용할 수 있다.

### ✏️super() - 조상 클래스의 생성자

this()와 마찬가지로 super()도 생성자.

> **this()** 같은 클래스의 다른 생성자 호출<br>
> **super()** 부모클래스의 생성자 호출

```java
public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D(1, 2, 3);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        // 생성자 첫 줄에 다른 생성자를 호출하지 않기 때문에 컴파일러는
        // super()를 삽입한다.
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getLocation() {
        return super.getLocation() + ", z :" + z;
    }
}
```
실행결과
```
PointTest.java:22: cannot resolve symbol
symbol : contructor Point()
location: class Point
Point3D(int x, int y, int z) {
^ 
1 error
```

컴파일러는 생성자가 없으면 기본생성자를 지정해주는데 Point 클래스에서 생성자를 지정해줬으므로 기본생성자가 없다.

Point3D 클래스의 생성자에서 조상 클래스의 생성자인 Point()를 찾을 수 없다는 내용


```java
Point3D(int x, int y, int z) {
    super(x, y);
}
```
super(x, y)를 통해 조상 클래스의 생성자를 호출한다.

> 조상 클래스의 멤버변수는 이처럼 조상의 생성자에 의해 초기화되도록 해야 한다.