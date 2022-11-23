class Solution {
    //Stefan Pochman's solution
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                char ch = board[i][j];
                if(ch != '.')
                {
                    String row = Character.toString(ch)+Integer.toString(i)+"_";
                    String col = Character.toString(ch)+"_"+Integer.toString(j);
                    String block = Character.toString(ch)+Integer.toString(i/3)+Integer.toString(j/3);
                    if(!set.add(row) || !set.add(col) || !set.add(block)) return false;
                }
            }
        }
        
        return true;
    }
}