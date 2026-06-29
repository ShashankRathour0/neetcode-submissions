/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
            if (intervals == null || intervals.isEmpty()) {
            return true;
        }

        // Sort the intervals based on start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        // Check for overlaps
        for (int i = 1; i < intervals.size(); i++) {
            // If the current meeting's start time is less than the previous meeting's end time
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                // There's an overlap, return false
                return false;
            }
        }

        // If no overlaps, return true
        return true;

    }
}
