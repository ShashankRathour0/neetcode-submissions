class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>(); // To store the number and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Return the indices
            }

            // Add the current number and its index to the map
            map.put(nums[i], i);
        }

        // No solution (according to the problem, this won't happen as there's always a valid pair)
        throw new IllegalArgumentException("No two sum solution");
    }
}
