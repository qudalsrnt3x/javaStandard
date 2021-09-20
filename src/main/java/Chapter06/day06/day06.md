### 💡Day 06 변수와 메서드
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️변수의 종류
> 선언위치에 따라 클래스변수, 인스턴스변수, 지역변수 세 종류로 나뉜다.

#### 인스턴스변수(instance variable)
- 인스턴스는 독립적인 저장공간을 가지므로 서로 다른 값을 가질 수 있다.
- **인스턴스가 생성될 때 생성**된다.

#### 클래스변수(class variable)
- 인스턴스변수 앞에 static을 붙인다. 인스턴스변수와 달리, 클래스변수는 모든 인스턴스가 공통된 저장공간(변수)을 공유하게 된다.
- 클래스이름.클래스변수 와 같은 형식으로 사용
- **클래스가 메모리에 '로딩(loading)'될 때 생성**되어 프로그램이 종료될 때 까지 유지된다.

#### 지역변수(local variable)
- 메서드 내에 선언되어 메서드 내에서만 사용 가능, 메서드가 종료되면 소멸된다.
- **변수 선언문이 수행되었을 때 생성**된다.

<br>

### ✏️클래스변수와 인스턴스변수

카드 게임에 사용되는 카드 클래스를 예시로 어떤 속성을 클래스 변수로 선언할 것이며, 어떤 속성들을 인스턴스변수로 선언할 것인지 생각해보자.

```java
class Card {
    String kind; // 무늬
    int number; // 숫자
    
    static int width = 100; // 폭
    static int height = 250; // 높이
}
```

- 각 카드는 자신만의 무늬(kind)와 숫자(number)를 유지하고 있어야 하기 때문에 독립적으로 선언해야 한다. 그러므로 인스턴스변수로 선언한다.

- 각 카드의 폭(width)와 높이(height)는 모든 인스턴스가 공통적으로 같은 값을 유지해야하므로 클래스변수로 선언한다.

> 인스턴스변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.

<br>

### ✏️메서드

> **메서드(method)**는 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것이다.

#### 메서드를 사용하는 이유

- 높은 재사용성(reusability)
- 중복된 코드의 제거 (반복되는 문장들 대신 메서드를 호출)
- 프로그램의 구조화

#### 메서드의 return문

- 반환값의 유무에 관계없이 모든 메서드에는 적어도 하나의 return문이 있어야 한다.
- 반환타입이 void인 경우는 컴파일러가 자동으로 return;을 추가해준다.
```java
void printGugudan(int dan){
	for(int i = 1; i <= 9;i++){
    	System.out.printf("%d * %d = %d%n", dan, i, dan * i);
    }
    return; // 반환 타입이 void이므로 생략가능, 컴파일러가 자동추가
}
```
- 반환타입이 void가 아닌 경우, 즉 반환값이 있는 경우, 반드시 return문이 있어야 한다.
```java
int multiply(int x, int y){
	int result = x * y;
    
    return result; // 반환 타입이 void가 아니므로 생략불가
}
```
- if문 조건식의 경우 참, 거짓 둘 다 return문을 사용한다.
```java
int max(int a, int b){
	if(a > b)
    	return a; // 조건식이 참일 때 실행된다.
    else
    	return b: // 조건식이 거짓일 때 실행된다.
}
```

#### 매개변수의 유효성 검사

- 메서드의 구현부{}를 작성할 때, 제일 먼저 해야 하는 일이 매개변수의 값이 적절한 것인지 확인하는 것이다.
```java
float divide(int x, int y){
	// 작업을 하기 전에 나누는 수(y)가 0인지 확인한다.
    if(y == 0){
    	System.out.println("0으로 나눌 수 없습니다.");
        return 0; // 매개변수가 유효하지 않으므로 메서드를 종료한다.
    }
    
    return x / (float)y;
}
```

> 매개변수의 유효성 검사하는 코드는 반드시 넣는 것이 좋다.

<br>

### ✏️JVM의 메모리 구조
> 응용프로그램이 실행되면, JVM은 시스템으로부터 프로그램을 수행하는데 필요한 메모리를 할당받고 JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.

#### JVM - 주요 영역 3가지
![](https://images.velog.io/images/qudalsrnt3x/post/70f11c4d-f5ce-477c-9c72-d88c65a8f968/image.png)
<p style="text-align: center;">출처: https://anota-co.tistory.com</p>

- 메서드 영역(method area)<br>
  `프로그램 실행 중 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스파일(*.class)을 읽어서 분석하여 클래스에 대한 정보(클래스 데이터)를 이곳에 저장한다.`


- 힙(heap)<br>
  `인스턴스가 생성되는 공간, 프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성된다.`


- 호출스택(call stack 또는 execution stack)<br>
  `호출스택은 메서드의 작업에 필요한 메모리 공간을 제공한다. `

#### 호출스택의 특징

- 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
- 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
- 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.
- 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.

```java
class CallStackTest {
	public staic void main(String[] args){
    	firstMethod(); // static메서드는 객체 생성없이 호출가능하다.
    }
    
    static void firstMethod(){
    	secondMethod();
    }
    
    static void secondMethod(){
    	System.out.println("secondMethod()");
    }
}
```

main()이 firstMethod()를 호출하고 firstMethod()는 secondMethod()를 호출한다.

![](https://images.velog.io/images/qudalsrnt3x/post/b4374735-562a-4049-90ef-6c8ba9a64a7d/image.png)
<p style="text-align: center;">출처: https://anota-co.tistory.com</p>

---
#### 🚩출처

JVM의 구조 - https://gptjs409.github.io/java/2019/09/04/jvm.html
