### 💡Day 10 상속(inheritance)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️상속의 정의
> 상속이란, 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것이다.

#### 장점

- 상속을 통해서 클래스를 작성하면 보다 적은 양의 코드로 새로운 클래스를 작성할 수 있다.
- 코드의 재사용성을 높이고 중복을 제거하여 프로그램의 생산성과 유지보수에 크게 기여한다.

#### 사용
- 키워드 <span style="color: red;">extends</span> 와 함께 사용
```java
class child extends Parent {
    // ...
}
```

#### 특징
- 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
- 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

### ✏️클래스간의 관계

> 클래스를 재사용하는 방법은 크게 두 가지가 있다.
- 상속관계
- 포함관계

#### 포함관계 예시
```java
class Circle {
    int x;	// 원점의 x좌표
    int y;	// 원점의 y좌표
    int r;	// 반지름(radius)
}

class Point {
    int x;
    int y;
}
```

Point 클래스를 재사용해서 Circle클래스를 작성하면 다음과 같다.
```java
class Circle {
    Point c = new Point(); // 원점
    int r;
}
```
- 한 클래스를 작성하는 데 다른 클래스를 멤버변수로 선언하여 포함시키는 것은 좋은 생각이다.
- 하나의 거대한 클래스를 작성하는 것보다 단위별로 여러 개의 클래스를 작성한 다음, 각 단위 클래스들을 포함관계로 재사용하면 보다 간결한 클래스를 작성할 수 있다.

### ✏️클래스간의 관계 결정하기

> 클래스를 작성하는데 있어서 상속관계를 맺을 것인지, 포함관계를 맺을 것인지 어떻게 정할까?
>
> **상속관계** '~은 ~이다.(is-a)'
> **포함관계** '~은 ~을 가지고 있다.(has-a)'

```java
public class DrawShape {
    public static void main(String[] args) {
        Point[] p = {
                new Point(100, 100),
                new Point(140, 50),
                new Point(200, 100)
        };

        Triangle t = new Triangle(p);
        Circle c = new Circle(new Point(150, 150), 50);

        t.draw();
        c.draw();
    }
}

class Shape { // 도형을 의미하는 Shape 클래스를 정의
    String color = "black";

    void draw() {
        System.out.printf("[color=%s]%n",color);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        this(0, 0);
    }

    String getXY() {
        return "(" + x + ", " + y + ")"; // x와 y값을 문자열로 반환
    }
}

class Circle extends Shape {
    Point center; // 원의 원점좌표
    int r; // 반지름

    Circle() {
        this(new Point(0, 0), 100);  // Circle(Point cneter, int r)를 호출
    }

    Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }

    @Override
    void draw() { // 원을 그리는 대신에 원의 정보를 출력하도록 했다.
        System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
    }
}

class Triangle extends Shape {
    Point[] p = new Point[3]; // 3개의 Point인스턴스를 담을 배열을 생성

    Triangle(Point[] p) {
        this.p = p;
    }

    @Override
    void draw() {
        System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
    }
}
```
- 도형을 의미하는 Shape클래스와 2차원 좌표에서의 점을 의미하는 Point클래스를 정의한 다음, 이 두 클래스를 재활용해서 Circle클래스와 Triangle클래스를 정의하였다.

- **A Circle is a Shape.**	// 원은 도형이다.
  A Circle is a Point?	// 원은 점이다?

- A Circle has a Shape?	// 원은 도형을 가지고 있다?
  **A Circle has a Point.**	// 원은 점을 가지고 있다.

> 매번 딱 떨어지진 않겠지만, 적어도 클래스 간의 관계를 맺어주는데 필요한 가장 기본적인 원칙이라고 할 수 있다.

### ✏️단일 상속(Single inheritance)

> 자바에서는 오직 단일 상속만을 허용한다.

```java
class TVCR extends TV, VCR {	// 에러. 조상은 하나만 허용된다.
    //...
}
```

#### 왜???

자바에서는 다중상속의 문제점을 해결하기 위해 다중상속의 장점을 포기하고 단일상속만을 허용한다.

