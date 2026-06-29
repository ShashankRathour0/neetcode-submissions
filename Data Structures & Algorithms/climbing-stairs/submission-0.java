class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int prev1 = 1; // Represents dp[i - 1]
        int prev2 = 1; // Represents dp[i - 2]
        
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2; // Current number of ways
            prev2 = prev1; // Update dp[i - 2] to dp[i - 1]
            prev1 = curr; // Update dp[i - 1] to current
        }
        
        return prev1;
    }
}
