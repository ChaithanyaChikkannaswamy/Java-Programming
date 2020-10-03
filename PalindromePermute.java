/**
 * @author chaithanyac
 * program to find if the given string is a permutation of a palindrome
 */

public class PalindromePermute {
    /*method to get the integer value of the specified unicode character*/
    int getCharNum(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int ch = Character.getNumericValue(c);
        if(ch >= a && ch <= z)
            return (ch - a);
        return -1;
    }

    /*method to check is the string is permutation of palindrome*/
    public boolean isPalindromePermute(String str){
        int count = 0;
        int num;
        int[] arr = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        char[] char_set = str.toCharArray();
        for(char c : char_set) {
            num = getCharNum(c);
            if (num != -1) {
                arr[num]++;
                if (arr[num] % 2 == 1) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args){
        PalindromePermute obj = new PalindromePermute();
        if(obj.isPalindromePermute("Java Java")) {
            System.out.println("The give string is permutation of a palindrome");
        }
        else{
            System.out.println("The given string is not a permutation of palindrome");
        }
    }
}
