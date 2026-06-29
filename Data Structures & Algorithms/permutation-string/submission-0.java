class Solution {
    public boolean checkInclusion(String s1, String s2) {
           if (s1.length() > s2.length()) {
            return false;
        }

        // Create a frequency map for characters in s1
        int[] s1Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Create a frequency map for the current window in s2
        int[] windowCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // If the counts match, return true
        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }

        // Start sliding the window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the new character to the window
            windowCount[s2.charAt(i) - 'a']++;
            // Remove the character that is now outside the window
            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            // If the counts match, return true
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }
}
