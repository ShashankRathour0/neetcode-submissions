class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the farthest reachable point, return false
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach or exceed the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // If we exit the loop, we cannot reach the last index
        return false;
    }
}
