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
    public int minMeetingRooms(List<Interval> intervals) {
          int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // Separate start and end times
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        // Sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0, endPointer = 0;
        int count = 0, maxCount = 0;

        // Traverse both arrays
        while (startPointer < n) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // A new meeting starts before the earliest ending meeting ends
                count++;
                maxCount = Math.max(maxCount, count);
                startPointer++;
            } else {
                // The earliest ending meeting ends
                count--;
                endPointer++;
            }
        }

        return maxCount;

    }
}
