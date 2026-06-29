class Solution {
    public int minDistance(String word1, String word2) {
              int m = word1.length();
        int n = word2.length();

        // Create a DP table with dimensions (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from word1 to make it empty
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters to make word1 equal word2
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation needed if characters are the same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of insert, delete, or replace
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        // The answer is in dp[m][n]
        return dp[m][n];
    }
}
