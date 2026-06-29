class Solution {
    public int[][] merge(int[][] intervals) {
          // If the input is empty, return an empty list
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the result list with the first interval
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Loop through the intervals and merge if needed
        for (int i = 1; i < intervals.length; i++) {
            // Get the last added interval in the merged list
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            // Check if there is an overlap
            if (current[0] <= last[1]) {
                // Merge the intervals by updating the end time of the last added interval
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap, so add the current interval to the merged list
                merged.add(current);
            }
        }

        // Convert the list to a 2D array and return it
        return merged.toArray(new int[merged.size()][]);
    }
}
