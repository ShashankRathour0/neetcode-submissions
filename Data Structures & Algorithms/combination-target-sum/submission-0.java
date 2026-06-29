class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
          List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums,int target , int index,ArrayList<Integer> current,List<List<Integer>> result )
    {
        if(target==0)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]<=target)
            {
                current.add(nums[i]);
                backtrack(nums,target-nums[i],i,current,result);
                current.remove(current.size()-1);
            }
        }


    }
}
