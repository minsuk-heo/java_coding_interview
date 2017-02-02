package CrackingTheCodingInterview;

/**
 * input = "abc"
 * output = "", "a", "b", "c", "ab", "ac", "bc", "abc"
 * solution: use Binary tree way, print when dept is the length -1 of input
 * http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
 * Created by minsukheo on 1/14/17.
 */
public class SubSetsFromSet {
    public static void main(String[] args) {
        SubSetsFromSet solution = new SubSetsFromSet();

        String input = "abc";
        StringBuilder sb = new StringBuilder("");
        solution.run(input, sb, 0);
    }

    private void run(String input, StringBuilder sb, int depth) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(sb).append(input.charAt(depth));
        sb2.append(sb);

        if(depth < input.length()-1){
            depth++;
            run(input, sb1, depth);
            run(input, sb2, depth);
        }

        else {
            System.out.println("result: "+sb1.toString());
            System.out.println("result: "+sb2.toString());
        }
    }
}
