class Solution {
    public List<List<String>> partition(String s) {
        
     List<List<String>> result = new ArrayList<>();
       
        backtrack(0,result,new ArrayList<>(),s);
        return result;
    }

    public void backtrack(int index,List<List<String>> result, List<String> arr,String s )
    {

if(index==s.length())
result.add(new ArrayList<>(arr));


       

        for(int i=index;i<s.length();i++)
        {
           if(isPalindrome(index,i,s)){

            arr.add(s.substring(index,i+1));
            backtrack(i+1,result,arr,s);
            arr.remove(arr.size()-1);
           }
        }
    }
     private boolean isPalindrome(int left, int right,String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
