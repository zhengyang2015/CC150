package Chapter1.chapter1_4;

public class chapter1_4 {
    //count all the characters in s and to check whether there is at most 1 odd count
    public boolean isPermutationOfPalindrome (String s) {
        int[] count = getCountNum(s);
        return check(count);
    }

    private int[] getCountNum(String s) {
        int[] count = new int[26];
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            int index = getCharNum(c);
            if (index != -1) {
                count[index]++;
            }
        }

        return count;
    }

    private int getCharNum(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }

        return -1;
    }

    private boolean check(int[] count) {
        boolean foundOdd = false;
        for (int i : count) {
            if (i % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    //we only want to know whether each character is even or odd, don't need to know the count
    public boolean isPermutationOfPalindrome2 (String s) {
        s = s.toLowerCase();
        int monitor = 0;
        for (char c : s.toCharArray()) {
            int index = getCharNum(c);
            monitor = flipBit(monitor, index);
        }

        return monitor == 0 || checkExactlyOne(monitor);
    }

    //to check whether there is only on bit to be 1
    //if there is only one bit to be 1, like 1000, if we describe it by 1, it will
    //be 0111, which has no overlap with the original one, so if we & this two number
    //we will get 0
    private boolean checkExactlyOne(int monitor) {
        return (monitor & (monitor - 1)) == 0;
    }

    //every time the character appears, we flip its index bit
    private int flipBit(int monitor, int index) {
        if (index < 0) {
            return monitor;
        }

        //0^1=1, 1^1=0
        monitor ^= (1 << index);
        return monitor;
    }
}
