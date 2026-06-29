class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        // Arrays
        backtrack(0,result,new ArrayList<>(),nums);
        return result;
    }

    public void backtrack(int index,List<List<Integer>> result, List<Integer> arr,int[] nums )
    {

        result.add(new ArrayList<>(arr));

        for(int i=index;i<nums.length;i++)
        {
            arr.add(nums[i]);
            backtrack(i+1,result,arr,nums);
            arr.remove(arr.size()-1);
        }
    }
}
