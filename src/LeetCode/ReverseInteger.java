package LeetCode;

/**
 * Created by minsukheo on 1/28/17.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));

    }

    public int reverse(int x)
    {
        //reversed value
        int result = 0;

        //iterate until x is 0
        while (x != 0)
        {
            // tail is the last digit
            int tail = x % 10;
            // newResult is the result*10 + tail
            int newResult = result * 10 + tail;
            // if overflow just return 0
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            // remove tail from x
            x = x / 10;
        }

        return result;
    }
}
