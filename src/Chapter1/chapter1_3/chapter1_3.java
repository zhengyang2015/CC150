package Chapter1.chapter1_3;

public class chapter1_3 {
    public void replacement (String s, int length) {
        if (s == null || s.length() == 0 || length == 0) {
            return;
        }

        char[] ss = s.toCharArray();
        //first scan to find all the " "
        int count = 0, newLength;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == ' ') {
                count++;
            }
        }
        newLength = length + 2 * count;

        //second scan to replace the " " with "%20"
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i] == ' ') {
                ss[newLength - 1] = '0';
                ss[newLength - 2] = '2';
                ss[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                ss[newLength - 1] = ss[i];
                newLength--;
            }
        }
    }
}
