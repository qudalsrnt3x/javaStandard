### 💡Day 09 변수의 초기화
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️변수의 초기화란?
> 변수를 선언하고 처음으로 값을 저장하는 것을 **'변수의 초기화'**라고 한다.

```java
class InitTest {
	int x;	// 인스턴스변수
    int y = x; //인스턴스변수
    
    void method1(){
    	int i; // 지역변수 (초기화 꼭 필요!!)
        int j = i; // 에러. 지역변수를 초기화하지 않고 사용
    }
}
```

- 멤버변수는 초기화를 하지 않아도 자동으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어진다.

- 지역변수는 자동으로 초기화가 이루어지지 않는다. 따라서 초기화 되지 않은 상태에서 변수 j를 초기화 하는데 사용할 수 없다.

### ✏️멤버변수 초기화 종류
#### 명시적초기화(explicit initialization)
- 변수의 선언과 동시에 값을 초기화
#### 생성자(constructor)
- 인스턴스 생성 시 생성자를 통해 값을 초기화
#### 초기화 블럭(initialization block)
- 인스턴스 초기화 블럭
- 클래스 초기화 블럭
  <br>
### ✏️초기화 방법

#### 명시적 초기화
> 변수를 선언과 동시에 초기화하는 것

```java
class Car {
	int door = 4; 	     // 기본형 변수의 초기화
    Engine e = new Engine(); // 참조형 변수의 초기화
}
```

#### 초기화 블럭
> **클래스 초기화 블럭** 클래스변수의 복잡한 초기화에 사용된다.
> **인스턴스 초기화 블럭** 인스턴스변수의 복잡한 초기화에 사용된다.

```java
class InitBlock {
	static { /* 클래스 초기화 블럭 */ }
    
    { /* 인스턴스 초기화 블럭 */ }
    // ...
}
```
- **클래스 초기화 블럭**은 클래스가 메모리에 처음 로딩될 때 한번만 수행
- **인스턴스 초기화 블럭**은 생성자와 같이 인스턴스가 생성될 때 마다 수행

#### 사용 예시
```java
Car() {
    count++;
    serialNo = count;    ------> 같은 코드 중복
    color = "white";
    gearType = "auto";
}

Car(String color, String gearType) {
    count++;
    serialNo = count;    ------> 같은 코드 중복
    this.color = color;
    this.gearType = gearType;
}
```
인스턴스 변수의 초기화는 주로 생성자를 사용하고, 인스턴스 초기화 블럭은 **모든 생성자에서 공통으로 수행돼야 하는 코드를 넣는데 사용**한다.
```java
// 리팩토링
{
    count++;
    searialNo = count;
}

Car() {
    color = "white";
    gearType = "auto";
}

Car(String color, String gearType) {
    this.color = color;
    this.gearType = gearType;
}
```
- 재사용성을 높이고 중복을 제거
- 객체지향프로그래밍이 추구하는 목표에 부합

### ✏️멤버변수의 초기화 시기와 순서

#### 초기화 시점
- 클래스변수의 초기화 시점
  `클래스가 처음 로딩될 때 단 한번 초기화 된다.`
- 인스턴스변수의 초기화 시점
  `인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.`

#### 초기화 순서
- 클래스변수의 초기화 순서
  `기본값 -> 명시적초기화 -> 클래스 초기화 블럭`
- 인스턴스변수의 최기화 순서
  `기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자`

```java
class InitTest {
    static int cv = 1;
    int iv = 1;
    
    static { cv = 2; }
    
    { iv = 2; }
    
    InitTest() {
    	iv = 3;
    }
}
```
![](https://images.velog.io/images/qudalsrnt3x/post/2863c932-80fc-4c37-90b4-b411a0d5cbd3/image.png)

> 클래스변수는 항상 인스턴스변수보다 먼저 생성되고 초기화 된다.

---
#### 🚩출처

변수와 메서드 - https://blog.daum.net/gunsu0j/44

