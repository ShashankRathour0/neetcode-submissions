class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        // Arrays
        backtrack(result,new ArrayList<>(),nums,new boolean[nums.length]);
        return result;
    }
      public void backtrack(List<List<Integer>> result, List<Integer> arr,int[] nums ,boolean[] used )
    {
        if(nums.length==arr.size())
        {
            result.add(new ArrayList<>(arr));
        }
        

        for(int i=0;i<nums.length;i++)
        {
          
if(used[i])continue;

used[i]=true;
            arr.add(nums[i]);
            backtrack(result,arr,nums,used);
            arr.remove(arr.size()-1);
            used[i]=false;
        }



    }
}
