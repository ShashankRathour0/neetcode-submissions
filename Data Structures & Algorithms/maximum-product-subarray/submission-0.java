class Solution {
    public int maxProduct(int[] nums) {
           if (nums == null || nums.length == 0) return 0;

        // Initialize variables for current max, min, and global max
        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            int tempMax = curMax; // Save current max before updating

            // Update curMax and curMin
            curMax = Math.max(nums[i], Math.max(nums[i] * curMax, nums[i] * curMin));
            curMin = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * curMin));

            // Update the global maximum
            globalMax = Math.max(globalMax, curMax);
        }

        return globalMax;
    }
}
