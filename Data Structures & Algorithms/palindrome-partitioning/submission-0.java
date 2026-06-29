class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore all possible partitions
        for (int end = start; end < s.length(); end++) {
            // Check if the substring is a palindrome
            if (isPalindrome(s, start, end)) {
                // Include this substring in the current partition
                current.add(s.substring(start, end + 1));
                // Recursively partition the remaining substring
                backtrack(s, end + 1, current, result);
                // Backtrack by removing the last added substring
                current.remove(current.size() - 1);
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
