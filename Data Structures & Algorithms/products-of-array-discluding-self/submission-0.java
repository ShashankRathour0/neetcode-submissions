class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int[] output = new int[n];

        // Step 1: Calculate the "left products"
        output[0] = 1; // No elements to the left of nums[0], so 1
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate the "right products" and multiply with "left products"
        int right = 1; // No elements to the right of nums[n-1], so 1
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }
}  
