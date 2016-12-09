package Chapter3.chapter3_3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class chapter3_3 {
    int stackCapacity;
    List<Stack<Integer>> stacks = new ArrayList<>();

    public void push (int value) {
        Stack lastStack = getLastStack();
        if (lastStack != null && lastStack.size() < stackCapacity) {
            lastStack.push(value);
        } else {
            Stack<Integer> nextStack = new Stack<>();
            nextStack.push(value);
            stacks.add(nextStack);
        }
    }

    public int pop () {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null) {
            throw new EmptyStackException();
        }
        int value = lastStack.pop();
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public Stack<Integer> getLastStack() {
        return stacks.get(stacks.size() - 1);
    }
}
