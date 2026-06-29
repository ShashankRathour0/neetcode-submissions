class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
          List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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
            break;
if(i>index&&nums[i]==nums[i-1])
continue;
            arr.add(nums[i]);
            backtrack(i+1,result,arr,nums,target-nums[i]);
            arr.remove(arr.size()-1);
        }



    }
}
