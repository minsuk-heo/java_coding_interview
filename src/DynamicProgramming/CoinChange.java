package DynamicProgramming;

/**
 *        0 1 2 3 4 5
 *   C1   1 1 1 1 1 1
 *   C2   1 1 2 2 3 3
 *   C3   1 1 2 3 4 5
 *
 *        0 1 2 3 4 5 6 7
 *   C1   1 1 1 1 1 1 1 1
 *   C2   1 1 1 2 2 2 3 3
 *   C3   1 1 1 1 1 3 4 4
 * Created by minsukheo on 2/8/17.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,3,5};
        System.out.println(findCombinationsCount(6,coins));
        System.out.println(findCombinationsCount2(6,coins));
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

    public static int findCombinationsCount2(int sum, int coins[]) {
        if (sum < 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[][] matrix = new int[coins.length][sum+1];
        for(int i=0;i<coins.length;i++) {

            for(int j=0;j<sum+1;j++) {
                if(i == 0) {
                    matrix[i][j] = 1;
                    continue;
                }
                if(coins[i] <= j) {
                    if(matrix[i][j - coins[i]] > -1) {
                        matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i]];
                    }
                    else{
                        matrix[i][j] = matrix[i-1][j];
                    }
                }
                else {
                    matrix[i][j] = matrix[i-1][j];
                }

            }
        }


        return matrix[coins.length-1][sum];
    }
}
