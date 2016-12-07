package Chapter1.chapter1_2;

import java.util.Arrays;

public class chapter1_2 {
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i)]--;
            if (count[str2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public String sort (String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public boolean isPermutation2 (String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return sort(str1).equals(sort(str2));
    }

    public static void main () {
        System.out.print(new chapter1_2().isPermutation("aaa", "aaa"));
    }
}
