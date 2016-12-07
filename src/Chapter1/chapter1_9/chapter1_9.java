package Chapter1.chapter1_9;

public class chapter1_9 {
    public boolean isRotation (String str1, String str2) {
        //if str2 is a rotation of str1, then there is a rotate point of str1 for rotation
        //for example, str1 = waterbottle, if we rotate after wat, then str2 = erbottlewat
        //let x = wat, y = erbottle, then str1 = xy and str2 = yx
        //regardless of where the rotate point is, yx is always the substring of xyxy, which means
        //str2 is always the substring of st1str1 if str2 is the rotation of str1
        int len = str1.length();
        if (len == str2.length() && len > 0) {
            str1 = str1 + str1;
            return isSubstring(str1, str2);
        }
        return false;
    }

    private boolean isSubstring(String str1, String str2) {
        return false;
    }
}
