package DynamicProgramming;

/**
 *        0 1 2 3 4 5
 *   C1   1 1 1 1 1 1
 *   C2   1 1 2 2 3 3
 *   C3   1 1 2 3 4 5
 *
 * Created by minsukheo on 2/8/17.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(findCombinationsCount(5,coins));
    }
    public static int findCombinationsCount(int sum, int vals[]) {
        if (sum < 0) {
            return 0;
        }
        if (vals == null || vals.length == 0) {
            return 0;
        }

        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < vals.length; ++i) {
            for (int j = vals[i]; j <= sum; ++j) {
                dp[j] += dp[j - vals[i]];
            }
        }
        return dp[sum];
    }
}
