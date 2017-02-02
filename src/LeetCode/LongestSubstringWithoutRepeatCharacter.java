package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *Given a string, find the length of the longest substring without repeating characters.
 *
 *Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatCharacter {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatCharacter lsw = new LongestSubstringWithoutRepeatCharacter();
        System.out.println(lsw.lengthOfLongestSubstring("abcabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int longest = 0;
        // store new char to check repeating with next characters
        Map<Character, Boolean> hash = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(hash.containsKey(s.charAt(i))) {
                // if the char has appeared before
                // check if current sb is longer than longest and update it if longer
                if(longest < sb.length()) {
                    longest = sb.length();
                }

                // delete start to repeated character in sb
                sb.delete(0, sb.indexOf(Character.toString(s.charAt(i)))+1);

                // add current char in sb
                sb.append(s.charAt(i));
            }
            else {
                // if new char, add the char in sb and add char in hash
                sb.append(s.charAt(i));
                hash.put(s.charAt(i), true);
            }
        }
        // if current sb is longer than longest, update longest
        if(sb.length() > longest) longest = sb.length();
        return longest;
    }
}
