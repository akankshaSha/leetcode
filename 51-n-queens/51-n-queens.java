class Solution {
    public static boolean canPlace(boolean board[][], int row, int col)
    {
        for(int i=0; i<col; i++) if(board[row][i]) return false;
        for(int i=0; i<row; i++) if(board[i][col]) return false;

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) if(board[i][j]) return false;
        for(int i=row, j=col; i>=0 && j<board[row].length; i--, j++) if(board[i][j]) return false;
        return true;
    }

    public static List<List<String>> placeQueen(boolean board[][], int row)
    {
        List<List<String>> res=new ArrayList<>();
        if(row==board.length)
        {
            List<String> resr=new ArrayList<>();
            for(boolean r[]: board)
            {
                String a="";
                for(boolean e: r)
                {
                    if(e) a+="Q";
                    else a+=".";
                }
                resr.add(a);
            }
            res.add(resr);
            return res;
        }

        boolean placed=false;
        for(int col=0; col<board[row].length; col++)
        {
            if(canPlace(board, row, col))
            {
                board[row][col]=true;
                res.addAll(placeQueen(board, row+1));
                board[row][col]=false;
            }
        }
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        boolean board[][]=new boolean[n][n];        
        return placeQueen(board, 0);
    }
}