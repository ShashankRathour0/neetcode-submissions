class Solution {
    public int reverse(int x) {
          int result = 0;
        int sign = (x < 0) ? -1 : 1;  // Check if the number is negative

        x = Math.abs(x);  // Work with absolute value of x

        while (x != 0) {
            int digit = x % 10;  // Get the last digit
            x /= 10;  // Remove the last digit from x

            // Check for overflow before appending the digit to result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;  // Return 0 if the result overflows
            }

            result = result * 10 + digit;  // Append the digit to the result
        }

        return result * sign;
    }
}
