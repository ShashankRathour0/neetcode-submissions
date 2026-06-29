class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtrack(0, 0, n,result, new StringBuilder());
        return result;
    }
    public void  backtrack(int open, int close,int n,List<String> result,StringBuilder str)
    {
        if(str.length()==2*n)
        {
            result.add(str.toString());
        }
        if(open<n)
        {
            str.append("(");
            backtrack(open+1,close,n,result,str);
            str.deleteCharAt(str.length()-1);
        }
        if(close<open)
         {
            str.append(")");
            backtrack(open,close+1,n,result,str);
            str.deleteCharAt(str.length()-1);
        }


    }
}
