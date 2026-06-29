class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int low = 1, high = 0;
    
    // Find the maximum number of bananas in any pile (the upper bound for eating rate)
    for (int pile : piles) {
        high = Math.max(high, pile);
    }

    // Perform binary search
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (canFinish(piles, h, mid)) {
            high = mid; // Try a smaller eating rate
        } else {
            low = mid + 1; // Increase the eating rate
        }
    }
    
    return low;
    }
    private boolean canFinish(int[] piles, int h, int k) {
    int hours = 0;
    for (int pile : piles) {
        hours += (pile + k - 1) / k; // This is the ceiling of pile / k
    }
    return hours <= h; // If we can finish within h hours
}
}
