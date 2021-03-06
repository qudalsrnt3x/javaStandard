### ๐กDay 23 Stack๊ณผ Queue
> ์ด ๊ธ์ ๋จ๊ถ์ฑ๋์ ์๋ฐ์ ์ ์ 3/e๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ๊ณต๋ถํ ๋ด์ฉ์ ์ ๋ฆฌํ ๊ธ์๋๋ค.
>
> **์์ค์ ๋ฆฌ**: https://github.com/qudalsrnt3x/javaStandard

### โ๏ธStack๊ณผ Queue?
- ์คํ์ ์ ์ฅํ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ฅ ๋จผ์  ๊บผ๋ด๊ฒ ๋๋ LIFO(Last in First Out) ๊ตฌ์กฐ

- ํ๋ ์ฒ์์ ์ ์ฅํ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ฅ ๋จผ์  ๊บผ๋ด๊ฒ ๋๋ FIFO(First in First Out) ๊ตฌ์กฐ

![](https://images.velog.io/images/qudalsrnt3x/post/14e5d5b9-e4a5-4231-9d9d-d13ca5577b81/image.png)

#### ์คํ๊ณผ ํ๋ฅผ ๊ตฌํํ๊ธฐ ์ํด์  ์ด๋ค ์ปฌ๋ ์ ํด๋์ค๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ด ์ข์๊น?
- ์คํ : ArrayList์ ๊ฐ์ ๋ฐฐ์ด๊ธฐ๋ฐ์ ์ปฌ๋ ์ ํด๋์ค๊ฐ ์ ํฉ
- ํ : LinkedList๋ก ๊ตฌํํ๋ ๊ฒ์ด ์ ํฉ

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
์คํ๊ฒฐ๊ณผ
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
์๋ฐ์์ Stack์ ํด๋์ค๋ก ๊ตฌํ, Queue๋ ์ธํฐํ์ด์ค๋ก๋ง ์ ์๋์ด์๊ธฐ ๋๋ฌธ์ Queue ์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ ํด๋์ค๋ฅผ ์ฌ์ฉํ๋ฉด ๋๋ค.

#### ์คํ๊ณผ ํ์ ํ์ฉ
> **์คํ์ ํ์ฉ ์** - ์์๊ณ์ฐ, ์์๊ดํธ๊ฒ์ฌ, ์๋ํ๋ก์ธ์์ undo/redo, ์น๋ธ๋ผ์ฐ์ ์ ๋ค๋ก/์์ผ๋ก
>
> **ํ์ ํ์ฉ ์** - ์ต๊ทผ์ฌ์ฉ๋ฌธ์, ์ธ์์์ ๋๊ธฐ๋ชฉ๋ก, ๋ฒํผ(Buffer)

- Stack ์์

```java
package Chapter11.day23;

import java.util.Stack;

public class StackEx1 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("1.๋ค์ดํธ");
        goURL("2.๋ค์ด๋ฒ");
        goURL("3.์ผํ");
        goURL("4.๊ตฌ๊ธ");

        printStatus();

        goBack();
        System.out.println("= '๋ค๋ก' ๋ฒํผ์ ๋๋ฅธ ํ");
        printStatus();

        goBack();
        System.out.println("= '๋ค๋ก' ๋ฒํผ์ ๋๋ฅธ ํ");
        printStatus();

        goForward();
        System.out.println("= '์์ผ๋ก' ๋ฒํผ์ ๋๋ฅธ ํ");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= ์๋ก์ด ์ฃผ์๋ก ์ด๋ ํ =");
        printStatus();
    }

    public static void printStatus() {
        System.out.println("back:" + back);
        System.out.println("forwoad:" + forward);
        System.out.println("ํ์ฌํ๋ฉด์ '" + back.peek() + "' ์๋๋ค.");
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
์คํ๊ฒฐ๊ณผ
```
back:[1.๋ค์ดํธ, 2.๋ค์ด๋ฒ, 3.์ผํ, 4.๊ตฌ๊ธ]
forwoad:[]
ํ์ฌํ๋ฉด์ '4.๊ตฌ๊ธ' ์๋๋ค.

= '๋ค๋ก' ๋ฒํผ์ ๋๋ฅธ ํ
back:[1.๋ค์ดํธ, 2.๋ค์ด๋ฒ, 3.์ผํ]
forwoad:[4.๊ตฌ๊ธ]
ํ์ฌํ๋ฉด์ '3.์ผํ' ์๋๋ค.

= '๋ค๋ก' ๋ฒํผ์ ๋๋ฅธ ํ
back:[1.๋ค์ดํธ, 2.๋ค์ด๋ฒ]
forwoad:[4.๊ตฌ๊ธ, 3.์ผํ]
ํ์ฌํ๋ฉด์ '2.๋ค์ด๋ฒ' ์๋๋ค.

= '์์ผ๋ก' ๋ฒํผ์ ๋๋ฅธ ํ
back:[1.๋ค์ดํธ, 2.๋ค์ด๋ฒ, 3.์ผํ]
forwoad:[4.๊ตฌ๊ธ]
ํ์ฌํ๋ฉด์ '3.์ผํ' ์๋๋ค.

= ์๋ก์ด ์ฃผ์๋ก ์ด๋ ํ =
back:[1.๋ค์ดํธ, 2.๋ค์ด๋ฒ, 3.์ผํ, codechobo.com]
forwoad:[]
ํ์ฌํ๋ฉด์ 'codechobo.com' ์๋๋ค.
```

- Queue ์์
```java
package Chapter11.day23;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;  //Queue์ ์ต๋ 5๊ฐ๊น์ง๋ง ์ ์ฅ๋๋๋ก ํ๋ค.

    public static void main(String[] args) {
        System.out.println(">>");

        while (true) {
            try {
                // ํ๋ฉด์ผ๋ก๋ถํฐ ๋ผ์ธ๋จ์๋ก ์๋ ฅ๋ฐ๋๋ค.
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine().trim();

                if ("".equals(input)) continue;

                    if (input.equalsIgnoreCase("q")) {
                        System.exit(0);
                    } else if (input.equalsIgnoreCase("help")) {
                        System.out.println(" help - ๋์๋ง์ ๋ณด์ฌ์ค๋๋ค.");
                        System.out.println(" q ๋๋ Q - ํ๋ก๊ทธ๋จ์ ์ข๋ฃํฉ๋๋ค.");
                        System.out.println(" history - ์ต๊ทผ์ ์๋ ฅํ ๋ช๋ น์ด๋ฅผ " + MAX_SIZE + "๊ฐ ๋ณด์ฌ์ค๋๋ค.");
                    } else if (input.equalsIgnoreCase("history")) {
                        int i = 0;
                        // ์๋ ฅ๋ฐ์ ๋ช๋ น์ด๋ฅผ ์ ์ฅํ๊ณ ,
                        save(input);

                        // LinkedList์ ๋ด์ฉ์ ๋ณด์ฌ์ค๋ค.
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
                System.out.println("์๋ ฅ์ค๋ฅ์๋๋ค.");
            }
        }
    }

    public static void save(String input) {
        // Queue์ ์ ์ฅํ๋ค.
        if (!"".equals(input))
            q.offer(input);

        // queue์ ์ต๋ํฌ๊ธฐ๋ฅผ ๋์ผ๋ฉด ์ ์ผ ์ฒ์ ์๋ ฅ๋ ๊ฒ์ ์ญ์ ํ๋ค.
        if (q.size() > MAX_SIZE)
            q.remove();
    }
}
```
<br>

### PriorityQueue

- ์ ์ฅํ ์์์ ๊ด๊ณ์์ด ์ฐ์ ์์๊ฐ ๋์ ๊ฒ๋ถํฐ ๊บผ๋ด๊ฒ ๋๋ค.
- null์ ์ ์ฅํ  ์ ์๋ค.

์ ์ฅ๊ณต๊ฐ์ผ๋ก ๋ฐฐ์ด์ ์ฌ์ฉํ๋ฉฐ, ๊ฐ ์์๋ฅผ 'ํ(heap)'์ด๋ผ๋ ์๋ฃ๊ตฌ์กฐ์ ํํ๋ก ์ ์ฅํ๋ค.

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
์คํ๊ฒฐ๊ณผ
```
[1, 2, 5, 3, 4]
1
2
3
4
5
```

์ฐ์ ์์๋ ์ซ์๊ฐ ์์์๋ก ๋์ ๊ฒ์ผ๋ก ์ ํด์ง๋ค.

