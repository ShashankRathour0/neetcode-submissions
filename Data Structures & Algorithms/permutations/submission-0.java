class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,  new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

     private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        // If the current combination is complete, add it to the result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the nums array
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip already used numbers

            // Mark the number as used and add it to the current combination
            used[i] = true;
            current.add(nums[i]);

            // Recurse
            backtrack(nums, current, result, used);

            // Backtrack: Remove the last number and unmark it
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
