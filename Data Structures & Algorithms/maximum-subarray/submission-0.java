class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update current sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
