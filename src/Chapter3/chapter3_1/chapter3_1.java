package Chapter3.chapter3_1;

class FullStackException extends Exception {

}

class EmptyStackException extends Exception {

}

public class chapter3_1 {
    //use a single array to implement three stacks
    int stackNum = 3;
    int stackCapacity;
    int[] values;
    int[] sizes;

    public void init (int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * stackNum];
        this.sizes = new int[stackNum];
    }

    public void push (int stackIndex, int value) throws FullStackException {
        if (isFull(stackIndex)) {
            throw new FullStackException();
        }

        sizes[stackIndex]++;
        values[topIndex(stackIndex)] = value;
    }

    public int pop (int stackIndex) throws EmptyStackException {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }

        int result = values[topIndex(stackIndex)];
        values[topIndex(stackIndex)] = 0;
        sizes[stackIndex]--;

        return result;
    }

    public int peek (int stackIndex) throws EmptyStackException {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }

        return values[topIndex(stackIndex)];
    }

    private int topIndex(int stackIndex) {
        int offset = stackIndex * stackCapacity;
        int size = sizes[stackIndex];
        return offset + size - 1;
    }

    private boolean isEmpty(int stackIndex) {
        return sizes[stackIndex] == 0;
    }

    private boolean isFull (int stackIndex) {
        return sizes[stackIndex] == stackCapacity;
    }
}
