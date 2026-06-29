class Solution {
    public int maxCoins(int[] nums) {
          int n = nums.length;

        // Add 1 to both ends of the nums array
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = extendedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            extendedNums[i + 1] = nums[i];
        }

        // DP table
        int[][] dp = new int[n + 2][n + 2];

        // Fill DP table for subarrays of increasing length
        for (int length = 1; length <= n; length++) {
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        extendedNums[left - 1] * extendedNums[k] * extendedNums[right + 1]
                        + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }

        // The result is in dp[1][n]
        return dp[1][n];
    }
}
