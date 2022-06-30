class Solution {
    static boolean search(char[][] board, String word, int index, int row, int col)
    {
        if(index == word.length()) return true;
        if(row == board.length || col == board[row].length || row<0 || col<0) return false;
        if(board[row][col] != word.charAt(index)) return false;
        char ch=board[row][col];
        //index++;
        //System.out.println(index);
        board[row][col]='0';
        boolean up=false, down=false, right=false, left=false;
        if(row>0)
            up = search(board, word, index+1, row-1, col);
        if(row<board.length-1)
            down = search(board, word, index+1, row+1, col);
        if(col>0)
            left = search(board, word, index+1, row, col-1);
        if(col<board[row].length-1)
            right = search(board, word, index+1, row, col+1);
        
        boolean res=up||down||left||right||index==word.length()-1;
        if(!res) board[row][col]=ch;
        return res;
    }
    
    public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                if(search(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
}