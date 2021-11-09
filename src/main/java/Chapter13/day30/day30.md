## 쓰레드 thread

### 프로세스와 쓰레드

- 프로세스란 간단히 말해서 '실행 중인 프로그램(program)'이다.
- 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.


- 쓰레드란 프로세스 실행의 단위
- 모든 프로세스는 최소한 하나 이상의 쓰레드가 존재
- 둘 이상의 쓰레드를 가진 프로세스를 멀티쓰레드 프로세스라고 한다.

<img src="https://mblogthumb-phinf.pstatic.net/MjAxODAzMDFfMTkz/MDAxNTE5ODM5NTQ4MTQ2.kFxrV0b3md0ukj58I4_Us7IILfMx2h-Sm7Eo_mB8O90g.J9MYHCS2xFR9uNw0uDl-WZ5iGaiQAEFC-aLiZ8uktq4g.PNG.gjcka1234/ccc.png?type=w800" alt="쓰레드">


> **프로세스와 쓰레드의 차이** <br>
> 프로세스는 운영체제로부터 자원을 할당받는 작업의 단위이고 <br>
쓰레드는 프로세스가 할당받은 자원을 이용하는 실행의 단위이다.
> 

#### 멀티태스킹과 멀티쓰레딩

- 멀티쓰레딩은 하나의 프로세스에 여러 쓰레드가 동시에 작업
- ex) 메신저로 채팅하면서 파일을 다운로드받는다.

#### 멀티쓰레딩의 장점
- CPU의 사용률을 향상시킨다.
- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.

#### 멀티쓰레딩의 단점

- 동기화(synchronization), 교착상태(deadlock)같은 문제를 고려해야 한다.

<br>

### 쓰레드의 구현과 실행

- 쓰레드 구현 방법
- Thread 클래스를 상속받은 경우와 Runnable 인터페이스를 구현한 경우의 인스턴스 생성 방법이 다르다.


```java
// 1. Thread 클래스를 상속
class myThread extends Thread {
    public void run() { /* 작업내용 */ }    // Thread클래스의 run()을 오버라이딩
}
```
```java
// 2. Runnable 인터페이스를 구현
class MyThread implements Runnable {
    public void run() { /* 작업내용 */ }    // Runnable인터페이스의 run()을 구현
}
```
- 구현
```java
package Chapter13.day31;

// 쓰레드의 구현과 실행
public class ThreadEx1 {
    public static void main(String[] args) {

        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);  // 생성자 Thread(Runnable target)

        t1.start();
        t2.start();

    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());  // 조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread() 현재 실행 중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}
```

- Runnable 인터페이스를 구현한 경우, Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 다음,
- 이 인스턴스를 Thread클래스의 생성자의 매개변수로 제공해야 한다.


#### 쓰레드의 실행 - start()

- 쓰레드를 생성했다고 해서 자동으로 실행되는 것은 아니다. start()를 호출해야만 실행된다.
- 사실 바로 실행되는 것이 아니라, 대기 상태에서 자신의 차례가 되면 실행된다.

- 한 번 실행이 종료된 쓰레드는 다시 실행할 수 없다.
- 하나의 쓰레드에 대해 start()를 두 번 이상 호출하면 IllegalThreadStatueException 이 발생한다.

```java
ThreadEx1_1 t1 = new ThreadEx1_1();
t1.start();
t1.start(); // 예외 발생

        
ThreadEx1_1 t1 = new ThreadEx1_1();
t1.start();
t1 = new ThreadEx1_1();
t1.start();
```

<br>

### start()와 run()

- run 메서드는 생성된 쓰레드를 실행시키는 것이 아니라 단순히 클래스에 선언된 메서드를 호출하는 것일 뿐이다.
- main 메서드 위에 run 메서드가 스택에 쌓이게 된다.

<img src="https://wjrmffldrhrl.github.io/assets/images/java/thread/stack1.png">


- start 메서드는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택을 생성한 다음에 run()을 호출해서, 생성된 호출스택에 run()이 첫번째로 올라가게 된다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile10.uf.tistory.com%2Fimage%2F99D5373359F976562CA93D" alt="호출스택">

위의 그림의 설명 순서
1. main메서드에서 쓰레드의 start메서드를 호출합니다.
2. start메서드는 쓰레드가 작업을 수행하는데 사용될 새로운 호출스택을 생성합니다.
3. 생성된 호출스택에 run메서드를  호출해서 쓰레드가 작업을 수행하도록 합니다.
4. 이제는 호출스택이 2개이기 때문에 스케쥴러가 정한 순서에 의해서 번갈아 가면서 실행합니다.

※ 쓰레드가 둘 이상일 때는 호출스택의 최상위에 있는 메서드일지라도 대기상태에 있을 수 있습니다. <br>
※ 작업을 마친 쓰레드, 즉 run()의 수행이 종료된 쓰레드는 호출스택이 모두 비워지면서 이 쓰레드가 사용하던 호출스택은 사라집니다. <br>
※ main메서드의 작업을 수행하는 것도 쓰레드입니다. <br>
프로그램을 실행되기 위해서는 작업을 수행하는 쓰레드가 최소 하나는 필요하며, main메서드가 프로그램을 실행하면 기본적으로 생성되는 쓰레드입니다. <br>

<br>

### 싱글쓰레드와 멀티쓰레드

하나의 쓰레드로 두 작업을 처리하는 경우, 한 작업을 마친 후에 다른 작업을 시작하지만,
두 개의 쓰레드로 작업을 하는 경우에는 짧은 시간동안 2개의 쓰레드가 번갈아 가면서 작업을 수행해서 둥시에 두 작업이 처리되는 것과 같이 느끼게 한다.

<img src="https://wjrmffldrhrl.github.io/assets/images/java/thread/schedule.png">

- 하나의 쓰레드로 두 개의 작업을 수행한 시간과 두개의 쓰레드로 두 개의 작업을 수행한 시간은 거의 같다.
- 이유는 쓰레드간의 작업 전환(context switching)에 시간이 걸리 때문

### 쓰레드 우선순위

쓰레드는 우선순위(priority)라는 속성을 가지고 있다.
쓰레드가 수행하는 작업의 중요도에 따라 쓰레드의 우선순위를 서로 다르게 지정하여 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있다.

```java
package Chapter13.day34;

public class ThreadEx8 {
    public static void main(String[] args) {

        // main 메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드 내에서 생성되는 쓰레드는 기본적으로 우선순위가 5가 된다.
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        th2.setPriority(7); // 쓰레드를 실행하기 전에만 우선순위를 바꿀 수 있다.

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}

class ThreadEx8_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++);
        }
    }
}

class ThreadEx8_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++);
        }
    }
}

```

- 쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다.
- main메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드내에서 생성하는 쓰레드의 우선순위는 자동적으로 5가 된다.

#### 멀티코어에서는 우선순위에 차등을 두어 쓰레드를 실행시키는 것이 별 효과가 없다.
