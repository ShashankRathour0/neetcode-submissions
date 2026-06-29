class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // There's 1 way to make amount 0 (by using no coins)

        // For each coin, update the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // The final answer is the number of ways to make the target amount
        return dp[amount];
    }
}
