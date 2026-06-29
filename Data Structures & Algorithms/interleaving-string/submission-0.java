class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
         if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int l1=computeLCS(s1,s3);
        int l2=computeLCS(s2,s3);
        if(l1+l2==s3.length())
        return true;

        return false;


    }
    private int computeLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
