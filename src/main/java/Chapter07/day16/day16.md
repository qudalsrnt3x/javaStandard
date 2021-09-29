### 💡Day 16 인터페이스(interface)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️인터페이스란?

인터페이스는 USB 인터페이스, SATA 인터페이스 하드디스크 등 컴퓨터 주변 장치와 실생활에서도 많이 사용되며, 서로 다른 하드웨어 장치들이 상호 데이터를 주고받을 수 있는 규격을 의미한다.

<span style="background-color: #ffeaa7; color: black;">이러한 규격이 필요한 이유는 무엇일까?</span>

규격을 정해 놓으면 서로 다른 회사가 만든 장치일지라도 주변 장치를 문제없이 결합할 수 있기 때문이다. 가령 실생활에서 사용하고 있는 220V를 예로 들 수 있다. 220V를 표준 규격으로 사용하고 있는 우리나라에서는 다양한 회사들이 이 규격에 맞추어 제품을 만들고 있기 때문에 규격에 맞기만 하면 언제나 연결이 가능하게 된다.

> 자바에서 인터페이스란 **규격과 같은 역할**을 한다. 인터페이스를 만들고 그 안의 속성(변수)과 기능(메소드)을 각 클래스에서 구현하면 인터페이스에 나열된 메소드와 동일한 이름의 메소드를 구현하지만, 구현한 내용은 서로 다르게 되며 인터페이스로 인한 **다형성이 실현**된다.

```java
interface 인터페이스이름 {
    public static final 타입 상수이름 = 값;
    public abstract 메서드이름(매개변수);
}
```
```java
// public을 생략하면 자동으로 붙는다.
interface PhoneInterface {
    // public static final은 생략가능하다.
    public static final int TIMEOUT = 10000;
    // 추상메소드, public abstract은  생략가능하다.
    public abstract void sendCall();
    public abstract void receiveCall();
}
```
인터페이스를 구성했으니 상속받는 클래스를 만들어보자
인터페이스를 상속받기 위해 implements 키워드를 사용한다.
```java
class SamsungPhone implements PhoneInterface {
    // 인터페이스의 모든 메소드들을 오버라이딩해야 한다.(추상 클래스이기 때문)
    @Override
    public void sendCall() {
    	System.out.println("띠리링");
    }
    
    @Override
    public void receiceCall() {
    	System.out.println("전화가왔습니다")
    }
    
    // 메소드를 추가 작성할 수 있다. ( class이기 때문)
    public void flash() {
    System.out.println("전화기에 불이 켜졌습니다.");
}   
```
인터페이스의 메소드는 상속받은 클래스에서 모두 오버라이드 해야 한다. 그 이유는 추상 메소드로만 작성되어 있기 때문이다. abstract가 붙은 추상 메소드는 오버라이드 해서 사용해야하기 때문이다.

> 모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.
> 모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다.
> 단, static메서드와 디폴트 메서드는 예외(JDK1.8부터)

생략된 제어자는 컴파일 시에 컴파일러가 자동적으로 추가해준다.

### ✏️인터페이스의 상속

#### 다중 상속 가능

- 자바에서는 기본적으로 다중 상속을 지원하지 않지만, 인터페이스에서는 가능하다.
- 하지만 인터페이스의 다중 상속이 인터페이스의 참다운 의미는 아니다. (자주 쓰이지 않는다.)

### ✏️인터페이스를 이용한 다형성

> 해당 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있다.<br>
> 인터페이스 타입의 형변환도 가능하다.

#### 메서드의 매개변수 타입으로 사용한다는 것
```java
void attack(Fightable f) {
   //...
}
```
인터페이스 타입의 매개변수가 갖는 의미는 메서드 호출 시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공해야한다는 것이다.

```java
Fightable method(){
    ...
    Fighter f = new Fighter();
    return f;
    // return new Fighter();
}
```

> 리턴 타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다.

예시
```java
interface Parseable {
    // 구문 분석작업을 수행한다.
    void parse(String fileName);
}

class ParserManager {
    // 리턴타입이 Parseable 인터페이스이다.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
            // return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - XML parsing completed.");
    }
}

class HTMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - HTML parsing completed.");
    }
}

public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }
}
```

Parseable인터페이스는 구문분석을 수행하는 기능을 구현할 목적으로 추상메서드를 정의했다.
ParserManager 클래스의 getParser메서드는 매개변수로 넘겨받는 type의 값에 따라 XMLParser인스턴스 또는 HTMLParser인스턴스를 반환한다.
<br>

### ✏️인터페이스의 장점

- 개발시간을 단축시킬 수 있다.<br>
  `일단 인터페이스가 작성되면, 이를 사용해서 프로그램을 작성하면 된다.`<br>
- 표준화가 가능하다.<br>
  `기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하여 프로그램을 작성하도록 함으로써 보다 일관되고 정형화된 프로그램의 개발이 가능하다.`<br>
- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
- 독립적인 프로그래밍이 가능하다.<br>
  `클래스의 선언과 구현을 분리시킬 수 있다.`<br>



