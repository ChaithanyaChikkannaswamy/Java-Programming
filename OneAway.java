/**
 * @author chaithanyac
 * method to find if the given two strings are one edit away
 * edit operation includes: replace, insert, delete
 */

public class OneAway {
    boolean isOneEdit(String str1, String str2) {
        /*If the given strings are equal return false*/
        if (str1.equals(str2))
            return false;

        /*If the length difference of the two strings are more than 1, return false*/
        int strlen1 = str1.length();
        int strlen2 = str2.length();
        if ((strlen1 - strlen2) > 1 || (strlen2 - strlen1) > 1)
            return false;

        /*check for replace/insertion/deletion*/
        int i = 0;
        int j = 0;
        int dif = 0;
        if (i < strlen1 && j < strlen2) {
            if (str1.charAt(i) != str2.charAt(j)) {
                dif++;
                if(strlen1 > strlen2){
                    i++;
                }
                if(strlen2 > strlen1){
                    j++;
                }
                if(strlen1 == strlen2) {
                    i++;
                    j++;
                }
            }
            else{
                i++;
                j++;
            }
            if (dif > 1){
                return false;
            }
        }

        /*check if the length of string is same after the edit*/
        if(dif == 1 && strlen1 != strlen2 && (i != strlen1 || j != strlen2)){
            return false;
        }
        return true;
    }
