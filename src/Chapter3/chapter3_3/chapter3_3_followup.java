package Chapter3.chapter3_3;

import java.util.ArrayList;
import java.util.EmptyStackException;

class Node {
    public int value;
    public Node above;
    public Node below;
    public Node (int value) {
        this.value = value;
        this.above = null;
        this.below = null;
    }
}

class Stack {
    private int capacity;
    public Node top, bottom;
    int size;

    public Stack (int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public boolean isFull () {
        return size == capacity;
    }

    private void join (Node above, Node below) {
        if (below != null) {
            below.above = above;
        }
        if (above != null) {
            above.below = below;
        }
    }

    public boolean push (int value) {
        if (isFull()) {
            return false;
        }

        Node n = new Node(value);
        size++;
        if (size == 1) {
            bottom = n;
        }
        join(n, top);
        top = n;
        return true;
    }

    public int pop () {
        if (top == null) {
            throw new EmptyStackException();
        }
        Node t  = top;
        top =top.below;
        size--;
        return t.value;
    }

    public int peek () {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public int removeBottom () {
        Node b = bottom;
        if (bottom != null) {
            bottom = bottom.above;
        }
        if (bottom != null) {
            bottom.below = null;
        }
        size--;
        return b.value;
    }
}

public class chapter3_3_followup {
    //shift the bottom elem form next stack to the current stack after removing the top
    //elem of the current stack
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public void init (int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack () {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public boolean isEmpty () {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt (int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int remove_item;
        if (removeTop) {
            remove_item = stack.pop();
        } else {
            remove_item = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return remove_item;
    }
}
