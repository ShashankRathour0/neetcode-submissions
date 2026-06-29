class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left =0;
        int ans =0;

        for(int right =0;right<s.length();right++)
        {
            if(set.contains(s.charAt(right))){
           while(left<=right&&s.charAt(left)!=s.charAt(right))
           {
            
            set.remove(s.charAt(left));
            left++;
           }
        
           set.remove(s.charAt(right));
   left++;
            }
            set.add(s.charAt(right));
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
