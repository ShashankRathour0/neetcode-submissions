class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] means whether s[0..i-1] can be segmented using the words in the dictionary
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // base case: empty string can always be segmented
        
        // Iterate through all positions in the string
        for (int i = 1; i <= s.length(); i++) {
            // Check every substring s[j..i-1]
            for (int j = 0; j < i; j++) {
                // If dp[j] is true and the substring s[j..i-1] is in the word set
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further if we found a valid segmentation
                }
            }
        }
        
        // The answer is whether s[0..s.length()-1] can be segmented
        return dp[s.length()];
    }
}
