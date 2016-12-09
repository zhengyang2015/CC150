package Chapter3.chapter3_4;

import java.util.Stack;

public class chapter3_4 {
    //use stack1 to store the new element, use stack2 to store the old element
    //after stack2's elements have been remove totally, push next patch elements in
    //stack1 to stack2
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void add (int value) {
        stack1.push(value);
    }

    public int poll () {
        shiftStacks();
        return stack2.pop();
    }

    public int peek () {
        shiftStacks();
        return stack2.peek();
    }

    private void shiftStacks () {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
