package CrackingTheCodingInterview;
import java.util.Arrays;

/**
 * anagram: true if listen and silent (if two string has same alphabets it is anagram)
 * better ask if space is considered as string
 * uppercase is different from lowercase
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class Anagram {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.run("Listen ", "silent"));
    }

    private boolean run(String str1, String str2) {
        // change all characters to lowercase and remove whitespace
        str1 = str1.toLowerCase().trim();
        str2 = str2.toLowerCase().trim();
        // sort alphabet in the string
        str1 = sort(str1);
        str2 = sort(str2);
        // check if alphabetically sorted str1 and str2 are same
        if(str1.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }

    private String sort(String str1) {
        char[] arr = str1.toCharArray();
        Arrays.sort(arr);
        String sortedStr = new String(arr);
        return sortedStr;
    }
}
