class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
          int[] result= new int[nums.length-k+1];
          int ans=0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index to the deque
            deque.offerLast(i);

            // Add the maximum of the current window to the result
            if (i >= k - 1) {
                result[ans++]=nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
