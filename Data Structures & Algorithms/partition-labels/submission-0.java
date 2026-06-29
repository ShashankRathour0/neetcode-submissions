class Solution {
    public List<Integer> partitionLabels(String s) {
           List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        // Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        // Partition the string
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the current partition
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));

            // If we reach the end of the partition
            if (i == end) {
                result.add(end - start + 1); // Size of the partition
                start = i + 1;              // Start of the next partition
            }
        }

        return result;
    }
}
