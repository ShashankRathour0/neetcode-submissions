class Solution {
    public int minCostClimbingStairs(int[] cost) {
          int n = cost.length;

        // Edge cases for very short arrays
        if (n == 1) {
            return cost[0];
        }

        // DP array to store minimum cost to reach each step
        int[] dp = new int[n + 1];
        dp[0] = 0; // Starting point
        dp[1] = 0; // Starting at step 1 has no initial cost

        // Fill the DP array
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n]; // Cost to reach the "top"
    }
}
