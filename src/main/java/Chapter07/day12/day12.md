### 💡Day 12 package와 import
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️패키지(package)

> 패키지란, 클래스의 묶음이다. 패키지에는 클래스 또는 인터페이스를 포함시킬 수 있다.

- 서로 관련된 클래스들끼리 그룹 단위로 묶어 놓음으로써 클래스를 효율적으로 관리할 수 있다.
- 클래스가 물리적으로 하나의 클래스파일(.class)인 것과 같이 패키지는 물리적으로 **하나의 디렉토리**이다.

#### 패키지의 선언
> package 패키지명;

하나의 소스파일(클래스)에 단 한번만 선언될 수 있다. 해당 소스파일에 포함된 모든 클래스나 인터페이스는 선언된 패키지에 속하게 된다.

#### 이름없는 패키지(unnamed package)

모든 클래스는 반드시 하나의 패키지에 포함되어야 한다고 했는데 그럼에도 지금까지 소스파일을 작성할 때 패키지를 선언하지 않고도 아무런 문제가 없었던 이유는 자바에서 기본적으로 제공하는 '이름없는 패키지'때문이다.

### ✏️import문

> 사용하고자하는 클래스의 패키지를 미리 명시할 때 사용

#### 선언
> import 패키지명.클래스명;
> 	또는
> import 패키지명.*;

#### 선언 순서
1. package문
2. import문
3. 클래스 선언

#### static import문

- static import문을 사용하면 static멤버를 호출할 때 클래스 이름을 생략할 수 있다.
```java
import static java.lang.Integer.*; //Integer클래스의 모든 static 메서드
import static java.lang.Math.random; // Math.random()만.
import static java.lang.System.out; // System.out을 out만으로 참조가능
```

#### java.lang패키지

System, String과 같은 java.lang패키지의 클래스들은 패키지명 없이 사용할 수 있음

-> 묵시적으로 선언되어있다.


