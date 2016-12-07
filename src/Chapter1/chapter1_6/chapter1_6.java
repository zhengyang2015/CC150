package Chapter1.chapter1_6;

public class chapter1_6 {
    public String compression (String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char curt = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == curt) {
                count++;
                i++;
            }
            sb.append(curt);
            sb.append(count);
        }

        return sb.length() < s.length()? sb.toString() : s;
    }
}
