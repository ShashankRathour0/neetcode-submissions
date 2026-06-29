class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int sum = 0;
        for (int num : nums) sum += num;

        // Check if the problem is solvable
        if ((sum + target) % 2 != 0 || sum + target < 0) return 0;

        int S1 = (sum + target) / 2;

        // DP array to count subsets with a given sum
        int[] dp = new int[S1 + 1];
        dp[0] = 1; // One way to make sum 0 (use no elements)

        for (int num : nums) {
            for (int j = S1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[S1];
    }
}
