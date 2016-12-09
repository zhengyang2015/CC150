package Chapter3.chapter3_2;

import java.util.Stack;

public class chapter3_2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push (int value) {
        stack1.push(value);
        if (value <= min()) {
            stack2.push(value);
        }
    }

    public int pop () {
        int value = stack1.pop();
        if (value == min()) {
            stack2.pop();
        }
        return value;
    }

    public int min () {
        if (stack2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack2.peek();
        }
    }
}
