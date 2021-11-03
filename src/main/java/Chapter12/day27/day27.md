### Generics란?
- 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크(complie-time type check)를 해주는 기능
- 객체의 타입 안정성을 제공한다.
- 타입체크와 형변환을 생략할 수 있다.
- JDK1.5에서 처음 도입

### 제네릭스 용어
- **Box<T\>** 제네릭 클래스. T의 Box 또는 T Box라고 읽는다.
- **T** 타입 변수 또는 타입 매개변수
- **Box** 원시 타입(raw type)

#### 제네릭 클래스 선언
```java
class Box {
	Object item;
    
    void setItem(Object item){
    	this.item = item;
    }
    
    Object getItem(){
    	return item;
    }
}
```
- 제네릭 클래스로 변경
```java
class Box<T> {	// 제네릭 타입 T를 선언
	T item;
    
    void setItem(T item). { this.item = item; }
    T getItem() { return item; }
}
```
- Box<T\>에서 T를 '타입 변수'라고 한다.

기존에는 다양한 종류의 타입을 다루는 메서드의 매개변수나 리턴타입으로 Object타입의 참조변수를 많이 사용했지만, 이젠 Object타입 대신 원하는 타입을 지정하면 된다.

#### 제네릭스의 제한
- 객체별로 다른 타입을 지정하는 것은 적절하다.
  제네릭스는 인스턴스별로 다르게 동작하도록 만든 기능이기 때문

```java
Box<Apple> appleBox = new Box<>();	// OK. Apple객체만 저장가능
Box<Grape> grapeBox = new Box<>();	// OK. Grape 객체만 저장가능
```

<br>

- static 멤버에 타입 변수 T를 사용할 수 없다.
  static 멤버는 타입 변수에 지정된 타입의 종류에 관계없이 동일한 것이어야 하기 때문

```java
class Box<T> {
	static T item;	// 에러
    static int compare(T t1, T t2){ ... } // 에러
}


//static 멤버에 T를 사용하면
//Box<Apple>.item과 Box<Grape>.item이 다르면 안되기 때문
```

<br>

- 제네릭 배열 타입의 참조변수를 선언하는 것은 가능하지만,
  new T[10]과 같이 배열을 생성하는 것은 불가능하다.

```java
class Box<T> {
	T[] itemArr;	// Ok. T타입의 배열을 위한 참조변수
    
    T[] toArray() {
    	T[] tmpArr = new T[itemArr.length];
        // 에러. 제네릭 배열 생성 불가
        ...
        return tmpArr;
    }
}

// 제네릭 타입의 인스턴스를 생성했을 때
// 컴파일 시 T가 어떤 타입인지 알 수 없기 때문
```

### 제한된 제네릭 클래스

- 제네릭을 이용해서 타입 문자로 사용할 타입을 명시하면 한 종류의 타입만 저장할 수 있도록 제한할 수 있다.
- 하지만 여전히 모든 종류의 타입을 지정할 수 있다.

#### 타입 매개변수 T에 저장할 수 있는 타입의 종류를 제한하는 방법은?

- 제네릭 타입에 'extends'를 사용한다.

```java
class FruitBox<T extends Fruit> {
	ArrayList<T> list = new ArrayList<T>();
}
```

- 한 종류의 타입만 담을 수 있을 뿐만 아니라, Fruit클래스의 자손들만 담을 수 있다는 제한을 추가
- 인터페이스를 조상으로 사용하고 싶다면 implements가 아닌 extends를 사용한다.

```java
interface Eatable {}
class FruitBox<T extends Eatable> { ... }

// 자손이면서 인터페이스도 구현해야 한다면 '&'기호 사용
class FruitBox<T extends Fruit & Eatable> { ... }
```

### 와일드 카드

> **< ? extends T>** 와일드 카드의 상한 제한. T와 그 자손들만 가능<br>
> **< ? super T>** 와일드 카드의 하한 제한. T와 그 조상들만 가능<br>
> **<?>** 제한 없음. 모든 타입이 가능. <? extends Object>와 동일

- 와일드 카드에는 '&'를 사용할 수 없다. 즉, <? extends T & E> 불가