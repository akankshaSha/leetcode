class Solution {
    boolean checkRows(char[][] board)
    {
        HashSet<Character> row=new HashSet<>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(board[i][j]=='.') continue;
                if(row.contains(board[i][j])) return false;
                row.add(board[i][j]);
            }
            row.clear();
        }
        return true;
    }
    
    boolean checkCols(char[][] board)
    {
        HashSet<Character> col=new HashSet<>();
        for(int j=0; j<board[0].length; j++)
        {
            for(int i=0; i<board.length; i++)
            {
                if(board[i][j]=='.') continue;
                if(col.contains(board[i][j])) return false;
                col.add(board[i][j]);
            }
            col.clear();
        }
        return true;
    }
    
    boolean checkBlocks(char[][] board)
    {
        for(int m=0; m<board.length; m+=3)
        {
            for(int n=0; n<board[m].length; n+=3)
            {
                HashSet<Character> block=new HashSet<>();
                for(int i=m; i<m+3; i++)
                {
                    for(int j=n; j<n+3; j++)
                    {
                        if(board[i][j]=='.') continue;
                        if(block.contains(board[i][j])) return false;
                        block.add(board[i][j]);
                    }
                }
                block.clear();
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        if(!checkRows(board)) return false;
        if(!checkCols(board)) return false;
        if(!checkBlocks(board)) return false;
        return true;
    }
}