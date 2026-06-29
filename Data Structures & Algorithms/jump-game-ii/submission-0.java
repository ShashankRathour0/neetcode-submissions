class Solution {
    public int jump(int[] nums) {
          int jumps = 0;        // Number of jumps made so far
        int currentEnd = 0;   // Current farthest point reachable with `jumps`
        int farthest = 0;     // Farthest point reachable with `jumps + 1`

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index reachable
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump's range
            if (i == currentEnd) {
                jumps++;          // Increment jump count
                currentEnd = farthest; // Update the range for the next jump

                // If we've already reached or exceeded the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
