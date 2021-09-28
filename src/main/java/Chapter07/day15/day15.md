### 💡Day 15 추상클래스(abstract class)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

<br>

### ✏️추상클래스란?
클래스를 설계도에 비유한다면, 추상클래스는 미완성 설계도에 비유할 수 있다. 공통부분 (선언부)만 만들고 상속을 통해 각각의 설계도를 완성하도록 구현되었다.

> 구현 목적은 다형성을 실현하기 위함이다.

```java
abstract class 클래스이름 {
   ...
}
```
#### 특징
- 추상클래스는 인스턴스를 생성할 수 없으며, 상속을 통해서만 완성될 수 있다.
- 추상클래스도 생성자가 있으며, 멤버변수와 메서드도 가질 수 있다.
- 추상메서드를 포함하고 있지 않은 클래스에도 키워드 'abstract'를 붙여서 추상클래스로 지정할 수 있다. 이는 클래스의 인스턴스를 생성하지 못하게 하기 위함

<br>

### ✏️추상메서드 (abstract method)
> 메서드의 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨 둔 것이 추상메서드이다.

#### 미완성 상태로 남겨 놓는 이유
- 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문이다.
```java
/*주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다.*/
abstract 리턴타입 메서드이름();
```


### ✏️추상클래스의 작성

```java
abstract class 클래스이름 {
   // 멤버변수
   // 생성자
   // 메서드
   // 추상메서드
}
```
예제

```java
abstract class Player {
    boolean pause;  // 일시정지 상태를 저장하기 위한 변수
    int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

    Player() {  // 추상 클래스 생성자
        pause = false;
        currentPos = 0;
    }
    /** 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다. */
    abstract void play(int pos); // 추상메서드
    /** 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 한다. */
    abstract void stop();

    void play(){
        play(currentPos);   // 추상메서드 사용가능
    }

    void pause() {
        if (pause) {    // pause가 true 일 때(정지상태)에서 pause가 호출되면,
            pause = false;  // pause의 상태를 false로 바꾸고
            play(currentPos);   // 현재의 위치에서 play 한다.
        } else {    // pause가 false일 때 (play상태)에서 pause가 호출되면,
            pause = true; // pause의 상태를 true로 바꾸고
            stop(); // play를 멈춘다.
        }

    }
}

class CDplayer extends Player {
    void play(int currentPos) {
        //.. 조상의 추상메서드를 반드시 구현
    }

    void stop() {
        //.. 조상의 추상메서드를 반드시 구현
    }

    // CDPlayer클래스에 추가로 정의된 멤버
    int currntTrack;

    void nextTrack() {
        currntTrack++;
        // ...
    }

    void preTrack() {
        if (currntTrack > 1) {
            currntTrack--;
            // ...
        }
    }

}
```

> abstract를 붙여서 추상메서드로 선언한 이유는 자손 클래스에서 추상메서드를 만드시 구현하도록 강요하기 위해서다.

### ✏️추상클래스를 왜 사용해야 하는가?

- 공통된 멤버변수와 메서드를 통일할 목적으로 사용된다.

같은 크기의 TV라도 기능의 차이에 따라 여러 종류의 모델이 있지만, 사실 이 들의 설계도는 아마 90%정도는 동일할 것이다. 서로 다른 TV의 설계도를 따로 그리는 것보다 이들의 공통부분만을 그린 미완성 설계도를 만들어 놓고, 이 미완성 설계도를 이용해서 각각의 설계도를 완성하는 것이 훨씬 효율적일 것이다.

- 추상클래스를 이용해서 실체 클래스를 구체화 한다.

추상클래스를 이용해서 작업을 하게 되면 규격에 맞는 구현을 할 수 있게 된다. 다형성을 실행할 수 있다.
