import java.util.Arrays;

public class Permutation {
    boolean isPermute(String str1, String str2){
        /*check the length o f two strings*/
        if(str1.length() != str2.length())
            return false;

        /*convert the strings to char array to compare the characters */
        char[] char_set1 = str1.toCharArray();
        char[] char_set2 = str2.toCharArray();

        /*sort the array for comparison*/
        Arrays.sort(char_set1);
        Arrays.sort(char_set2);

        /*compare character of each array to check for permutation*/
        for (int i = 0; i < str1.length(); i++)
            if(char_set1[i] != (char_set2[i]))
                return false;
        return true;
    }

    public static void main(String[] args){
        Permutation obj = new Permutation();
        if(obj.isPermute("lifeisnowhere", "nowhereislife"))
            System.out.println("The two strings are Permute");
        else {
            System.out.println("The two strings are not permute");
        }
    }
}
