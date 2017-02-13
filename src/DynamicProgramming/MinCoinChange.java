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
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
