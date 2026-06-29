class Solution {
    public int[] plusOne(int[] digits) {
         for (int i = digits.length - 1; i >= 0; i--) {
            // Increment the current digit
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // If no carry, return the result
            }
            // If the digit is 9, set it to 0 (carry over)
            digits[i] = 0;
        }
        
        // If all digits were 9, we need to add an extra leading 1
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the first digit to 1
        return result;
    }
}
