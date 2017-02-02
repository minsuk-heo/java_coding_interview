package LeetCode;

/**
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 *
 * Created by minsukheo on 1/15/17.
 */
public class LongestPalindrome {
    private int lo, maxLen;
    public static void main(String[] args) {
        String str = "bbb";
        LongestPalindrome solution = new LongestPalindrome();
        solution.run(str);
    }

    private void run(String str) {
        if(str.length() < 2 ) {
            System.out.println(str);
        }
        for(int i=0;i<str.length();i++) {
            checkpalindrome(str, i, i);
            checkpalindrome(str, i, i+1);
        }
        System.out.println(str.substring(lo, lo+maxLen));
    }

    private void checkpalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
