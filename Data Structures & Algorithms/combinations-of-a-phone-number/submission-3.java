class Solution {
    public List<String> letterCombinations(String digits) {
           // Edge case: if digits is empty
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        // Mapping of digits to letters
        String[] digitToChar = {
            "",     // 0 (not used)
            "",     // 1 (not used)
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        backtrack(digits, digitToChar, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, String[] digitToChar, int index, StringBuilder current, List<String> result) {
        // Base case: if the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the characters for the current digit
        String letters = digitToChar[digits.charAt(index) - '0'];

        // Loop through the characters and explore further
        for (char c : letters.toCharArray()) {
            current.append(c); // Add character to the current combination
            backtrack(digits, digitToChar, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
         } // Backtrack
    }
}
