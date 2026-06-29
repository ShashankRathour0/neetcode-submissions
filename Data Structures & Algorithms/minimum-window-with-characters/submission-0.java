class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map of characters in t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int validCount = 0; // Number of characters that meet the requirement
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            // Expand the window by including s[right]
            char c = s.charAt(right);
            right++;
            if (tFreq.containsKey(c)) {
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
                if (windowFreq.get(c).equals(tFreq.get(c))) {
                    validCount++;
                }
            }

            // Shrink the window from the left if all characters in t are satisfied
            while (validCount == tFreq.size()) {
                // Update the result if a smaller window is found
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                // Shrink the window
                char d = s.charAt(left);
                left++;
                if (tFreq.containsKey(d)) {
                    if (windowFreq.get(d).equals(tFreq.get(d))) {
                        validCount--;
                    }
                    windowFreq.put(d, windowFreq.get(d) - 1);
                }
            }
        }

        // Return the minimum window substring
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
