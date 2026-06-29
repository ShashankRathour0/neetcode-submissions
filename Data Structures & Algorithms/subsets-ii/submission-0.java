class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Iterate through the elements
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include the current element in the subset
            current.add(nums[i]);

            // Recurse with the next element
            backtrack(nums, i + 1, current, result);

            // Backtrack: Remove the last element
            current.remove(current.size() - 1);
        }
    }
}
