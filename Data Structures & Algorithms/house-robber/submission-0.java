class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // DP array to store maximum amount robbed up to each house
        int[] dp = new int[n];
        dp[0] = nums[0]; // If only robbing the first house
        dp[1] = Math.max(nums[0], nums[1]); // Max of robbing the first or the second house

        // Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // The last entry in dp contains the maximum amount that can be robbed
        return dp[n - 1];
    }
}
