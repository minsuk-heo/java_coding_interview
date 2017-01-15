package CrackingTheCodingInterview;

/**
 * you can go up one stairs at once
 * also you can go up two stairs at once
 * how many ways to go up N stairs
 *
 * Created by minsukheo on 1/14/17.
 */
public class CountWaysGoUpStairs {
    public static void main(String[] args) {
        CountWaysGoUpStairs solution = new CountWaysGoUpStairs();
        System.out.println(solution.run(10));
    }

    private int run(int nStairs) {
        if(nStairs == 0) {
            return 0;
        }
        else if(nStairs == 1) {
            return 1;
        }
        else if(nStairs == 2) {
            return 2;
        }
        else {
            return run(nStairs-1) + run(nStairs-2);
        }
    }
}
