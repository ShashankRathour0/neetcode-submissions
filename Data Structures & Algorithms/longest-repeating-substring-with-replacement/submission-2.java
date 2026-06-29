class Solution {
    public int characterReplacement(String s, int k) {
        int [] arr= new int[26];
int maxFre=0;
int ans =0;
int left=0;



for(int right=0;right<s.length();right++)
{

   arr[s.charAt(right)-'A']++;
maxFre=Math.max(maxFre,arr[s.charAt(right)-'A']);

int letterChangeRequired=(right-left+1)-maxFre;
if(letterChangeRequired>k)
{

arr[s.charAt(left)-'A']--;
left++;
}
ans = Math.max(ans,right-left+1);
}

return ans;
    }
}
