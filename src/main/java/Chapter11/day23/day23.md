### 💡Day 23 Stack과 Queue
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/qudalsrnt3x/javaStandard

### ✏️Stack과 Queue?
- 스택은 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO(Last in First Out) 구조

- 큐는 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(First in First Out) 구조

![](https://images.velog.io/images/qudalsrnt3x/post/14e5d5b9-e4a5-4231-9d9d-d13ca5577b81/image.png)

#### 스택과 큐를 구현하기 위해선 어떤 컬렉션 클래스를 사용하는 것이 좋을까?
- 스택 : ArrayList와 같은 배열기반의 컬렉션 클래스가 적합
- 큐 : LinkedList로 구현하는 것이 적합

```java
package Chapter11.day23;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue q = new LinkedList();

        stack.push("0");
        stack.push("1");
        stack.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("= stack =");
        while (!stack.empty())
            System.out.println(stack.pop());

        System.out.println("= Queue =");
        while (!q.isEmpty())
            System.out.println(q.poll());
    }
}
```
실행결과
```
= stack =
2
1
0
= Queue =
0
1
2
```
자바에서 Stack은 클래스로 구현, Queue는 인터페이스로만 정의되어있기 때문에 Queue 인터페이스를 구현한 클래스를 사용하면 된다.

#### 스택과 큐의 활용
> **스택의 활용 예** - 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
>
> **큐의 활용 예** - 최근사용문서, 인쇄작업 대기목록, 버퍼(Buffer)

- Stack 예시

```java
package Chapter11.day23;

import java.util.Stack;

public class StackEx1 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("1.네이트");
        goURL("2.네이버");
        goURL("3.야후");
        goURL("4.구글");

        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른 후");
        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른 후");
        printStatus();

        goForward();
        System.out.println("= '앞으로' 버튼을 누른 후");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();
    }

    public static void printStatus() {
        System.out.println("back:" + back);
        System.out.println("forwoad:" + forward);
        System.out.println("현재화면은 '" + back.peek() + "' 입니다.");
        System.out.println();
    }

    public static void goURL(String url) {
        back.push(url);
        if (!forward.empty())
            forward.clear();
    }

    public static void goForward() {
        if(!forward.empty())
            back.push(forward.pop());
    }

    public static void goBack() {
        if(!back.empty())
            forward.push(back.pop());
    }
}

```
실행결과
```
back:[1.네이트, 2.네이버, 3.야후, 4.구글]
forwoad:[]
현재화면은 '4.구글' 입니다.

= '뒤로' 버튼을 누른 후
back:[1.네이트, 2.네이버, 3.야후]
forwoad:[4.구글]
현재화면은 '3.야후' 입니다.

= '뒤로' 버튼을 누른 후
back:[1.네이트, 2.네이버]
forwoad:[4.구글, 3.야후]
현재화면은 '2.네이버' 입니다.

= '앞으로' 버튼을 누른 후
back:[1.네이트, 2.네이버, 3.야후]
forwoad:[4.구글]
현재화면은 '3.야후' 입니다.

= 새로운 주소로 이동 후 =
back:[1.네이트, 2.네이버, 3.야후, codechobo.com]
forwoad:[]
현재화면은 'codechobo.com' 입니다.
```

- Queue 예시
```java
package Chapter11.day23;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;  //Queue에 최대 5개까지만 저장되도록 한다.

    public static void main(String[] args) {
        System.out.println(">>");

        while (true) {
            try {
                // 화면으로부터 라인단위로 입력받는다.
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine().trim();

                if ("".equals(input)) continue;

                    if (input.equalsIgnoreCase("q")) {
                        System.exit(0);
                    } else if (input.equalsIgnoreCase("help")) {
                        System.out.println(" help - 도움말을 보여줍니다.");
                        System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                        System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
                    } else if (input.equalsIgnoreCase("history")) {
                        int i = 0;
                        // 입력받은 명령어를 저장하고,
                        save(input);

                        // LinkedList의 내용을 보여준다.
                        LinkedList tmp = (LinkedList) q;
                        ListIterator it = tmp.listIterator();

                        while (it.hasNext()) {
                            System.out.println(++i + "." + it.next());
                        }
                    } else {
                        save(input);
                        System.out.println(input);
                    }
            } catch (Exception e) {
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void save(String input) {
        // Queue에 저장한다.
        if (!"".equals(input))
            q.offer(input);

        // queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (q.size() > MAX_SIZE)
            q.remove();
    }
}
```
<br>

### PriorityQueue

- 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다.
- null은 저장할 수 없다.

저장공간으로 배열을 사용하며, 각 요소를 '힙(heap)'이라는 자료구조의 형태로 저장한다.

```java
package Chapter11.day23;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue pq = new PriorityQueue();
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);
        System.out.println(pq);

        Object obj = null;

        while ((obj = pq.poll()) != null)
            System.out.println(obj);

    }
}
```
실행결과
```
[1, 2, 5, 3, 4]
1
2
3
4
5
```

우선순위는 숫자가 작을수록 높은 것으로 정해진다.

