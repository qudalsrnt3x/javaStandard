### 💡Day 08 생성자(Constructor)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️생성자란?

> 생성자는 인스턴스가 생성될 때 호출되는 **'인스턴스 초기화 메서드'**이다.

#### 생성자의 특징
- 생성자는 인스턴스변수의 초기화 작업게 주로 사용된다.
- 인스턴스 생성 시에 실행되어야 할 작업을 위해서도 사용된다.
  <br>
- 생성자의 이름은 클래스의 이름과 같아야 한다.
- 생성자는 리턴 값이 없다.
  `생성자도 메서드이기 때문에 리턴값이 없다는 의미의 void를 붙여야 하지만, 모든 생성자가 리턴값이 없으므로 void를 생략할 수 있게 한 것이다.`

#### 생성자 정의

```java
class Card {
	Card() {	// 매개변수 없는 생성자
    	...
    }
    
    Card(String k, int num) {	// 매개변수가 있는 생성자
    	...
    }
}
```

생성자도 오버로딩이 가능하다.

> 💡연사자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.

#### 수행과정 예시
```java
Card c = new Card();
```
1. 연선자 new에 의해서 메모리(heap)에 Card클래스의 인스턴스가 생성된다.
2. 생성자 Card()가 호출되어 수행된다.
3. 연산자 new의 결과로, 생성된 Card인스턴스의 주소가 반환되어 참조변수 c에 저장된다.

> 지금까지 인스턴스를 생성하기위해 사용해왔던 **'클래스이름()'**이 바로 생성자였던 것!


### ✏️기본 생성자(default constructor)

모든 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 한다.
> 클래스에 생성자가 하나도 정의되지 않은 경우, 컴파일러는 자동적으로 아래와 같은 내용의 기본 생성자를 추가하여 컴파일 한다.
```java
클래스이름() {}
Card() {}
```

컴파일러가 자동적으로 기본 생성자를 추가해주는 경우는 '클래스 내에 생성자가 하나도 없을 때'뿐이라는 것을 명심하자

### ✏️매개변수가 있는 생성자

```java
class Car {
    String color;
    String gearType;
    int door;
    
    Car() {} // 기본생성자
    
    Car(String c, String g, int d) { // 생성자
    	color = c;
        gearType = g;
        door = d;
    }
}
```
Car인스턴스를 생성할 때, 생성자 Car()를 사용한다면, 인스턴스를 생성한 다음에 인스턴스변수들을 따로 초기화해주어야 하지만, 매개변수가 있는 생성자 Car(String color, String gearType, int door)를 사용한다면 인스턴스를 생성하는 동시에 원하는 값으로 초기화를 할 수 있게 된다.

```java
Car c = new Car();
c.color = "white";       -------->   Car c = new Car("white", "auto", 4);
c.gearType = "auto";
c.door = 4;
```
> 클래스를 작성할 때 다양한 생성자를 제공함으로써 인스턴스 생성 후에 별도로 초기화를 하지 않아도 되도록 하는 것이 바람직하다.

### ✏️생성자에서 다른 생성자 호출하기 - this(), this

- 생성자 간에 서로 호출이 가능하다.

> 생성자의 이름으로 클래스이름 대신 this를 사용한다.
> 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.

```java
class Car2 {
    String color; // 색상
    String gearType; // 변속기 종류
    int door; // 문의 갯수

    Car2(){
        this("white", "auto", 4); // Car2(String color, String gearType, int door) 호출
    }

    Car2(String color) {
        this(color, "auto", 4);
    }

    public Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
        // 인스턴스변수 = 매개변수
    }

    @Override
    public String toString() {
        return "Car2{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}

public class CarTest2 {
    public static void main(String[] args) {
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("blue");

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
    }
}
```
- this를 사용할 수 있는 것은 인스턴스멤버뿐이다. static메서드(클래스 메서드)에서는 인스턴스 멤버들을 사용할 수 없는 것처럼, 'this'역시 사용할 수 없다.
  `static 메서드는 인스턴스를 생성하지 않고도 호출될 수 있으므로 static메서드가 호출된 시점에 인스턴스가 존재하지 않을 수도 있기 때문이다.`

> **this** 인스턴스 자신을 가리키는 <span style="color: red;">참조변수</span>, 인스턴스의 주소가 저장되어 있다.<br>
> **this(), this(매개변수)** <span style="color: red;">생성자</span>, 같은 클래스의 다른 생성자를 호출할 때 사용한다.

#### 정리

> **인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야 한다.**
>
>1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
>2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?