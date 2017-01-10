package CrackingTheCodingInterview;

import java.util.Stack;

/**
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.solution1("abcd"));
        System.out.println(rs.solution2("abcd"));
    }

    // java way
    private String solution1(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // using stack
    private String solution2(String str) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }
}
