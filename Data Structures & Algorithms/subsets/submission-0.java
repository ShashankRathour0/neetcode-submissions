class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
   void generateSubsets(int[] nums, int index,ArrayList<Integer> list,  List<List<Integer>> result)
    {
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            generateSubsets(nums,i+1,list,result);
            list.remove(list.size()-1);
        }
    }
}
