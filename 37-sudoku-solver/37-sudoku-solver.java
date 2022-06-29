class Solution {
    static boolean canPlace(char[][] board, int row, int col, char ch)
    {
        for(int i=0; i<board.length; i++) if(board[i][col]==ch) return false;
        for(int i=0; i<board[row].length; i++) if(board[row][i]==ch) return false;
        int sbRow=(row/3)*3;
        int sbCol=(col/3)*3;
        for(int i=sbRow; i<sbRow+3; i++)
        {
            for(int j=sbCol; j<sbCol+3; j++)
                if(board[i][j]==ch)
                {
                    return false;
                }
        }
        return true;
    }
    
    static boolean solve(char[][] board, int row, int col)
    {
        boolean solved=false;
        if(row==board.length) return true;
        if(col==board[row].length) return solve(board, row+1, 0);
        if(board[row][col]!='.') return solve(board, row, col+1);
        
        for(char k='1'; k<='9'; k++)
        {
            if(canPlace(board, row, col, k))
            {
                board[row][col]=k;
                solved=solve(board, row, col+1);
                if(!solved)
                    board[row][col]='.';
            }
        }
        return solved;
    }
    public static void solveSudoku(char[][] board) {
       solve(board, 0, 0);
    }
}