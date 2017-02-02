package LeetCode;

/**
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by minsukheo on 1/28/17.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(13531));

    }

    public boolean isPalindrome(int x) {
        // negative or x == 10, 100... 1000
        if (x<0 || (x!=0 && x%10==0)) return false;
        // var for reversed integer
        int rev = 0;
        // generate reversed number
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }

        // x == rev for when x digits are even
        // x==rev/10 for when x digits are odd
        return (x==rev || x==rev/10);
    }
}
