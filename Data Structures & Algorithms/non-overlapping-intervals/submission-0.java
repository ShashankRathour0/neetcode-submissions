class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;

        // Sort intervals based on their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize the number of removed intervals and the end of the last selected interval
        int removed = 0;
        int lastEnd = intervals[0][1];

        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts before the last selected interval ends
            if (intervals[i][0] < lastEnd) {
                // Increment the removal count, as we need to remove the current interval
                removed++;
            } else {
                // Update the last end time to be the end of the current interval
                lastEnd = intervals[i][1];
            }
        }

        // Return the number of removed intervals
        return removed;
    }
}
