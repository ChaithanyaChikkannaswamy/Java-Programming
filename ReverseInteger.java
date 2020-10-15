/*
 * @author chaithanyac
 * method to reverse the digits of the integer
 */

class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while(x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        } 
        return reversed;
    }
}
