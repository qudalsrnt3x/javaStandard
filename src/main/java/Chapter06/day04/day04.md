### 💡Day 04 객체지향언어
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard


<br>

### ✏️객체지향언어란?

#### 객체지향의 기본 개념
> 실제 세계는 사물(객체)로 이루어져 있으며, 발생하는 모든 사건들은 사물간의 상호작용이다.

프로그램의 규모가 점점 커지고 사용자들의 요구가 빠르게 변화해가는 상황을 절차적 언어로는 극복하기 어렵다는 한계를 느끼고 객체지향언어를 이용한 개발방법론이 대안으로 떠오르게 됐다.

#### 객체지향언어
> 기존 절차적 언어의 한계를 극복하기 위해 코드 간에 서로 관계를 맺어줌으로써 보다 유기적으로 프로그램을 구성하는 것이 가능해졌다.

#### 특징

1. 코드의 재사용성이 높다.
2. 코드의 관리가 용이하다.
3. 신뢰성이 높은 프로그래밍을 가능하게 한다.

#### 객체지향언어의 핵심은 재사용성, 유지보수, 중복코드제거에 있다.

### ✏️클래스와 객체

#### 클래스의 정의
> 클래스의 정의: 객체를 정의해 놓은 것
> 클래스의 용도: 객체를 생성하는데 사용
>
> 유-무형의 것들을 객체로 간주한다.

#### 객체의 정의
> 객체의 정의: 실제로 존재하는 것, 사물 또는 개념
> 객체의 용도: 객체가 가지고 있는 기능과 속성에 따라 다름
>
> 유형의 객체: 책상, 의자, 자동차, TV와 같은 사물
> 무형의 객체: 수학공식, 프로그램 에러, 주문 등과 같은 논리나 개념

#### 예시

클래스와 객체의 관계는 쉽게 말해 제품 설계도와 제품과의 관계라고 할 수 있다.
TV설계도(클래스)는 TV라는 제품(객체)을 정의한 것이며, TV(객체)를 만드는데 사용된다.

### ✏️객체와 인스턴스

클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화(instantiate)라고 하며, 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스(instance)라고 한다.

> 클래스 -----------> 인스턴스 (객체)
>  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp인스턴스화

#### 객체의 구성요소 - 속성과 기능

```
속성(property) -> 멤버변수(variable)
기능(function) -> 메서드(method)
```

#### 인스턴스의 생성과 사용

> 클래스명 변수명;
> 변수명 = new 클래스명();
>
> Tv t;
> t = new Tv();

예제) TvTest

```java
class Tv {
    // Tv의 속성 (멤버변수)
    String color;
    boolean power;
    int channel;

    // TV의 기능 (메서드)
    void power(){
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}

public class TvTest {
    public static void main(String[] args) {
        // Tv클래스 타입의 참조변수 t를 선언,new를 통해 인스턴스가 메모리의 빈 공간에 생성된다.
        // 이 때, 멤버변수는 각 자료형에 해당하는 기본값으로 초기화 된다.
        Tv t = new Tv(); 
        // 참조변수 t에 저장된 주소에 있는 인스턴스의 멤버변수 channel에 7을 저장한다.
        t.channel = 7;
        // 참조변서 t가 참조하고 있는 Tv인스턴스의 channelDown메서드를 호출한다.
        t.channelDown();
        System.out.println("현재 채널은 " + t.channel + " 입니다.");
    }
}
```
> 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야 한다.


### ✏️객체 배열

- 객체 배열 안에 객체가 저장되는 것은 아니고, 객체의 주소가 저장된다. 사실 객체 배열은 참조변수들을 하나로 묶은 참조변수 배열인 것이다.
```
Tv tv1, tv2, tv3;   ----> Tv[] tvArr = new Tv[3];
```

- 각 요소는 참조변수의 기본값인 null로 자동 초기화 된다.
- 모든 배열이 그렇듯이 객체 배열도 같은 타입의 객체만 저장할 수 있다.

```java
public class TvTest4 {
    public static void main(String[] args) {
        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv객체 배열 생성 (배열에 값을 넣진 않은 상태)

        // Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv(); // 각 요소에 객체를 생성
            tvArr[i].channel = i + 10;   // 채널의 값을 i + 10으로 저장
        }

        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel=%d%n", i, tvArr[i].channel);
        }
    }
}

class Tv {
    // Tv의 속성 (멤버변수)
    String color; 
    boolean power;
    int channel;
    
    // TV의 기능 (메서드)
    void power(){
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}
```