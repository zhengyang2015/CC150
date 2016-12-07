package Chapter1.chapter1_1;

public class chapter1_1 {
    public boolean isUnique(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (charSet[index]) {
                return false;
            }
            charSet[index] = true;
        }

        return true;
    }

    //assume all the characters in s is lower case
    public boolean isUnique2 (String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        int monitor = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if ((monitor & (1 << index)) == 1) {
                return false;
            }
            monitor |= 1 << index;
        }

        return true;
    }

    public static void main (String[] args) {
        System.out.print(new chapter1_1().isUnique2("abca"));
    }
}
