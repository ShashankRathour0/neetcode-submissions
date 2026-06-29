class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
        // Arrays
        backtrack(0,result,new ArrayList<>(),nums,target);
        return result;
    }
      public void backtrack(int index,List<List<Integer>> result, List<Integer> arr,int[] nums, int target )
    {
        if(target==0)
        {
            result.add(new ArrayList<>(arr));
        }
        

        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]>target)
            continue;

            arr.add(nums[i]);
            backtrack(i,result,arr,nums,target-nums[i]);
            arr.remove(arr.size()-1);
        }



    }

}
