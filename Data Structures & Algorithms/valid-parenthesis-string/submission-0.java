class Solution {
    public boolean checkValidString(String s) {
         int low = 0, high = 0; // Initialize range of open parenthesis count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++; // Increment low for '('
                high++; // Increment high for '('
            } else if (c == ')') {
                low = Math.max(low - 1, 0); // Decrement low for ')' but keep it non-negative
                high--; // Decrement high for ')'
            } else if (c == '*') {
                low = Math.max(low - 1, 0); // '*' can be empty or ')'
                high++; // '*' can be '('
            }

            if (high < 0) {
                return false; // Too many ')' encountered
            }
        }

        return low == 0;
    }
}
