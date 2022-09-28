class Updation
{
    int x, y, value;
    Updation(int x, int y, int value)
    {
        this.x=x;
        this.y=y;
        this.value=value;
    }
}

class Solution {
    int numLivingN(int board[][], int x, int y)
    {
        int dx[]={-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[]={-1, 0, 1, 1, -1, -1, 0, 1};
        int count=0;
        for(int i=0; i<dx.length; i++)
        {
            int m=x+dx[i], n=y+dy[i];
            boolean inBounds=-1<m && m<board.length && -1<n && n<board[m].length;
            if(inBounds && board[m][n]==1) count++;
        }
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        List<Updation> updations=new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                boolean live=board[i][j]==1;
                int l=numLivingN(board, i, j);
                if(live && l<2) updations.add(new Updation(i, j, 0));
                if(live && l>3) updations.add(new Updation(i, j, 0));
                if(!live && l==3) updations.add(new Updation(i, j, 1));
            }
        }
        
        for(Updation updation: updations)
        {
            board[updation.x][updation.y]=updation.value;
        }
    }
}