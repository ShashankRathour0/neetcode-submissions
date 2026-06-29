class Solution {
    public int missingNumber(int[] nums) {
           int n = nums.length;
        int xor = 0;
        
        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        
        // XOR all numbers in the array
        for (int num : nums) {
            xor ^= num;
        }
        
        // The result will be the missing number
        return xor;
    }
}
