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
