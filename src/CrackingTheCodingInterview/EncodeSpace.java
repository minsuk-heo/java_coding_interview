package CrackingTheCodingInterview;

/**
 *
 * replace space with %20
 * ex)"hey how are you    "
 * return hey%20how%20are%20you
 *
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class EncodeSpace {
    public static void main(String[] args) {
        EncodeSpace es = new EncodeSpace();
        System.out.println(es.run("hey how are you   "));
    }

    private String run(String str) {
        return str.trim().replace(" ", "%20");
    }
}
