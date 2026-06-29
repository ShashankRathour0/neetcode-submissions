class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(dfs(n,m,board,word,i,j,0))
                return true;
            }
        }

        return false;

    }
   boolean dfs(int n, int m,char[][] board, String word,int i, int j, int index ){
     if(word.length()==index)
     return true;
if(i<0||j<0||i>=n||j>=m)
return false;
if(word.charAt(index)!=board[i][j])
return false;

char temp=board[i][j];
board[i][j]='#';


boolean ans=dfs(n,m,board,word,i+1,j,index+1)||dfs(n,m,board,word,i,j+1,index+1)||dfs(n,m,board,word,i-1,j,index+1)||dfs(n,m,board,word,i,j-1,index+1);
if(ans)
return true;
board[i][j]=temp;
return false;
    }
}
