class Solution {
    public int reverseBits(int n) {
         int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;         // Shift result to the left to make space for the new bit
            result |= (n & 1);    // Add the least significant bit of n to result
            n >>= 1;              // Shift n to the right to process the next bit
        }
        
        return result;
    }
}
