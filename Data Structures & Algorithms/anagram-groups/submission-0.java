class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          // Edge case: if the input array is empty, return an empty list
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store the grouped anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Create a frequency array for 26 lowercase English letters
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Convert the frequency array into a unique key (e.g., "2#1#0#0#...#0")
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count).append('#'); // Append count and separator
            }
            String key = keyBuilder.toString();
            
            // Group anagrams in the map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // Collect all grouped anagrams into a list
        return new ArrayList<>(map.values());
    }
}
