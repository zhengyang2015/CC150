package Chapter1.chapter1_5;

public class chapter1_5 {
    public boolean oneEditAway (String str1, String str2) {
        if (str1.length() == str2.length()) {
            return editReplacement(str1, str2);
        } else if (str1.length() - 1 == str2.length()) {
            return editIntersion(str2, str1);
        } else if (str1.length() + 1 == str2.length()) {
            return editIntersion(str1, str2);
        }
        return false;
    }

    private boolean editIntersion(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private boolean editReplacement(String str1, String str2) {
        boolean foundOne = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundOne) {
                    return false;
                }
                foundOne = true;
            }
        }
        return foundOne;
    }
}
