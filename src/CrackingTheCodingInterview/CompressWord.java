package CrackingTheCodingInterview;

/**
 *
 * abbcccccccd -> a1b2c7d1
 * abc -> abc if the compression (a1b1c1) is longer than original, return original
 *
 * Created by Minsuk_Heo on 1/8/2017.
 */
public class CompressWord {
    public static void main(String[] args) {
        CompressWord cw = new CompressWord();
        System.out.println(cw.run("abbcccccccd"));
        System.out.println(cw.run("abc"));
    }

    private String run(String str) {
        StringBuilder sb = new StringBuilder();
        char buf = 0;
        int cnt = 1;

        sb.append(str.charAt(0));

        for(int i=1;i<str.length();i++) {
            if(buf == str.charAt(i)) {
                cnt++;
            }
            else {
                buf = str.charAt(i);
                sb.append(cnt).append(str.charAt(i));
                cnt = 1;
            }
        }
        sb.append(cnt);

        if(sb.toString().length() > str.length()) {
            return str;
        }
        else {
            return sb.toString();
        }
    }
}
