package Archieve.Problems.medium;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 3, 5}, 50));
        System.out.println(coinChange_Rec(new int[]{1, 2, 3, 5}, 50));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int idx = coin; idx <= amount; idx++) {
                dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange_Rec(int[] coins, int amount) {
        int changeValue = change(coins, amount, 0);
        return changeValue >= 50000 ? -1 : changeValue;
    }

    private static int change(int[] coins, int amount, int idx) {
        if (idx >= coins.length || amount < 0) return 50000;
        if (amount == 0) return 0;
        return Math.min(
                change(coins, amount, idx + 1),
                1 + change(coins, amount - coins[idx], idx)
        );
    }
}
