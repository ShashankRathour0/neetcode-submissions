class Solution {
    public int[] countBits(int n) {
         int[] output = new int[n + 1]; // Array to store the number of 1's for each number
        
        for (int i = 1; i <= n; i++) {
            output[i] = output[i / 2] + (i & 1); // Apply the recurrence relation
        }
        
        return output;
    }
}
