class Solution {
    static int min(int a, int b, int c)
    {
        return a<b? (a<b? a: c): (b<c? b: c);
    }
    
    public int minPathSum(int[][] board) {
       int r=board.length-1, c=board[0].length-1;
        int cost[][]=new int[r+1][c+1];
        cost[r][c]=board[r][c];

        for(int i=r-1; i>=0; i--) cost[i][c]=cost[i+1][c]+board[i][c];
        for(int i=c-1; i>=0; i--) cost[r][i]=cost[r][i+1]+board[r][i];
        
        for(int i=r-1; i>=0; i--)
        {
            for(int j=c-1; j>=0; j--)
            {
                cost[i][j]=board[i][j]+Math.min(cost[i+1][j], cost[i][j+1]);
            }
        }
        return cost[0][0]; 
    }
}