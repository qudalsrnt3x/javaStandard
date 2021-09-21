### 💡Day 07 오버로딩(overloading)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️오버로딩이란?

한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메서드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메서드를 정의할 수 있다.
> 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것을 **'오버로딩(method overloading)'** 이라고 한다.

#### 오버로딩의 조건

- 메서드 이름이 같아야 한다.
- 매개변수의 개수 또는 타입이 달라야 한다.
  `반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.`

#### 예시

```java
void println()
void println(boolean x)
void println(char x)
void println(char[] x)
void println(double x)
void println(float x)
void println(int x)
void println(long x)
void println(Object x)
void println(String x)
```

오버로딩의 예로 가장 대표적인 것은 println메서드 이다. 넘겨주는 값의 타입에 따라서 위의 오버로딩된 메서드들 중의 하나가 선택되어 실행되는 것이다.

#### 몇 가지 예시
- 매개변수 이름이 다른 경우

```java
int add(int a, int b) { return a + b; }
int add(int x, int y) { return x + y; }
```

매개변수의 이름만 다를 뿐 매개변수의 타입이 같기 때문에 오버로딩이 성립하지 않는다.
<br>
- 리턴타입이 다른 경우
```java
int add(int a, int b) { return a + b;}
long add(int a, int b) { return (long)(a + b); }
```
매개변수의 타입과 개수가 일치하기 때문에 add(3,3)과 같이 호출하였을 때 어떤 메서드가 호출될 것인지 결정할 수 없기 때문에 성립하지 않는다.
<br>
- 매개변수 순서가 다를 경우
```java
long add(int a, long b) { return a + b; }
long add(long a, int b) { return a + b; }
```
두 메서드의 매개변수 순서가 다르기 때문에 오버로딩으로 간주한다.

### ✏️오버로딩의 장점

- 만일 메서드도 변수처럼 단지 이름만으로 구별된다면, 한 클래스내의 모든 메서드들은 이름이 달라야 한다. 그렇다면, 이전에 예로 들었던 10가지 println메서드들은 각기 다른 이름을 가져야 한다.
```
void println()
void printlnBoolean(boolean x)
void printlnChar(char x)
void printlnDouble(double x)
...
```

- 메서드의 이름을 절약할 수 있다. 하나의 이름으로 여러 개의 메서드를 정의할 수 있기 때문이다.
