class Solution {
    public int rob(int[] nums) {
     int n = nums.length;

        // Edge cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Helper function to calculate maximum rob amount in a linear array
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // Max robbed amount two houses ago
        int prev1 = 0; // Max robbed amount one house ago

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1; // Update prev2 to prev1
            prev1 = curr; // Update prev1 to current
        }

        return prev1; // Maximum amount robbed
    }
}
