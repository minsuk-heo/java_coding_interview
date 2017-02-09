package DynamicProgramming;
import java.util.Arrays;
/**
 * F(S) - minimum number of coins needed to make change for amount SS using coin denominations [c0 .. cn-1]
 ​​ ]
 * F(3) = min{F(3-c1), F(3-c2), F(3-c3)} + 1
 *      = min{F(3-1), F(3-2), F(3-3)} + 1
 *      = min{F(2), F(1), F(0)} + 1
 *      = min {1,1,0} + 1
 *      = 1
 *
 * Created by minsukheo on 2/8/17.
 */
public class MinCoinChange {
    public static void main(String[] args) {
        MinCoinChange mc = new MinCoinChange();
        int[] arr = {1,2,3};
        System.out.println(mc.coinChange(arr, 5));

    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
