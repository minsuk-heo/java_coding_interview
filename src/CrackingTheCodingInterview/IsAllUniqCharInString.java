package CrackingTheCodingInterview;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * return true if the string doesn't have duplicate characters
 * "ABCD" => true
 * "ABCA" => false
 *
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class IsAllUniqCharInString {
    public static void main(String[] args) {
        IsAllUniqCharInString solution = new IsAllUniqCharInString();
        System.out.println(solution.run("ABCD"));
        System.out.println(solution.run("ABCDE"));
        System.out.println(solution.run("ABCA"));
        System.out.println(solution.run("ABCB"));

        System.out.println(solution.runInplace("ABCD"));
        System.out.println(solution.runInplace("ABCDE"));
        System.out.println(solution.runInplace("ABCA"));
        System.out.println(solution.runInplace("ABCB"));
    }

    private boolean run(String str) {
        Map<Character, Boolean> hm = new HashMap<Character, Boolean>();

        for(int i=0;i<str.length();i++) {
            if(hm.containsKey(str.charAt(i))) {
                return false;
            }
            else {
                hm.put(str.charAt(i), true);
            }
        }
        return true;
    }

    private boolean runInplace(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        String sortedString = new String(strArr);
        for(int i=0;i<sortedString.length()-1;i++){
            if(sortedString.charAt(i) == sortedString.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
