### Annoataion이란?

- 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것
- 주석처럼 프로그래밍에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 정보를 제공할 수 있다.

#### 장점
- 설정정보를 코드에 포함시켜 유지할 수 있다.
- 설정 파일을 공유하는 불편함이 없다.
- 소스코드의 로직을 방해하지 않고, 특정 프로그램을 위해 정보를 제공할 수 있다.

#### 표준 애너테이션
- 자바에서 기본적으로 제공하는 애너테이션

<img src="https://media.vlpt.us/images/neity16/post/2f173b97-5466-4b94-9d2a-7a19a20bfca7/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-06-18%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%202.24.47.png" alt="애너테이션">

---
### @Override
- 조상의 메서드를 오버라이딩하는 것이라는 걸 컴파일러에게 알려주는 역할


### @Deprecated
- 더 이상 사용되지 않는 필드나 메서드에 붙인다.
- 이 애너테이션이 붙은 대상은 다른 것으로 대체되었으니 더 이상 사용하지 않을 것을 권한다는 의미 (사용은 할 수 있음)

> compile 시 -Xlint:deprecation 옵션을 붙이면 자세한 내용을 알 수 있다.

### @FunctionalInterface
- 함수형 인터페이스를 선언 할 때 사용

### @SuppressWarnings
- 컴파일러가 보여주는 경고메시지가 나타나지 않게 억제해준다.
- "deprecation", "unchecked", "rawtypes", "varargs" 등의 메시지 종류가 있다.

> -Xlint 옵션으로 컴파일해서 나타나는 경고의 내용 중 대괄호[] 안에 있는 것으로 메시지의 종류를 확인할 수 있다.

```java
/* unchecked 경고를 나타나지 않게 억제 */
// ArrayList는 제네식 클래스라서 타입을 지정해야 하는데 하지 않았기에 경고가 발생됨
@SuppressWarnings("unchecked")
ArrayList list = new ArrayList();
list.add(obj);
```
- 여러개의 경고를 동시에 억제 가능
```java
@SuppressWarnings({"deprecation", "unchecked"})
```

### @SafeVarargs
- 메서드에 선언된 가변인자의 타입이 non-reifiable타입일 경우, 해당 메서드를 선언하는 부분과 호출하는 부분에서 "unchecked" 경고가 발생한다.
- 이 때 해당 코드에 문제가 없다면 경고를 억제하기 위해 사용한다.
- static, final 이 붙은 메서드와 생성자에만 붙일 수 있다.
- 오버라이드될 수 있는 메서드에는 사용불가

> 습관적으로 @SafeVarargs와 @SuppressWarnings("varargs")를 같이 붙인다.

---

#### 메타 애너테이션
- 애너테이션에 붙이는 애너테이션으로 애너테이션의 적용대상(target)이나 유지기간(retention)등을 지정하는데 사용

### @Target
- 애너테이션이 적용가능한 대상을 지정하는데 사용

<img src="https://media.vlpt.us/images/neity16/post/71ef79b5-40d0-4d68-8538-29b0cca9013d/image.png">

```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
	String[] value();
}
```

### @Retention
- 애너테이션이 유지되는 기간을 지정하는데 사용

<img src="https://media.vlpt.us/images/neity16/post/8d738a7c-bfc1-423f-9e7f-aba1ecb9f587/image.png">


### @Documented
- 애너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 한다.
- 기본 애너테이션 중 @Override와 @SuppressWarnings를 제외하고는 모두 이 메타 애너테이션이 붙어 있다.

---

#### 애너테이션 타입 정의하기

> @interface 애너테이션이름 { <br>
>   타입 요소이름(); 	
> }

- 애너테이션 내에 선언된 메서드를 애너테이션의 요소(element)라고 한다.

```java
@interface TestInfo {
	int count();
    String testedBy();
    String[] testTools();
    TestType testType();
    DateTime testDate();
}

@interface DateTime {
    String yymmdd();
    String hhmmss();
}
```

#### 애너테이션 요소의 규칙
- 요소의 타입은 기본형, String, enum, annotation, Class만 허용
- ()안에 매개변수를 선언할 수 없다.
- 예외를 선언할 수 없다.
- 요소를 타입 매개변수로 정의할 수 없다.
