package Chapter3.chapter3_5;

import java.util.Stack;

public class chapter3_5 {
    //use to stack to sort
    public Stack<Integer> sortByStack (Stack<Integer> s) {
        Stack<Integer> stack = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            if (!stack.isEmpty() && stack.peek() > temp) {
                s.push(stack.pop());
            }
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }

        return s;
    }
}
