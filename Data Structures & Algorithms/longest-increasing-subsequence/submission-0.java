class Solution {
    public int lengthOfLIS(int[] nums) {
          List<Integer> tail = new ArrayList<>();

        for (int num : nums) {
            int index = Collections.binarySearch(tail, num);
            if (index < 0) {
                index = -(index + 1); // Find the insertion point
            }
            if (index < tail.size()) {
                tail.set(index, num);
            } else {
                tail.add(num); // Append if num is the largest element so far
            }
        }

        return tail.size();
    }
}
