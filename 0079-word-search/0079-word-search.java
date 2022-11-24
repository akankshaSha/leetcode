class Solution {
    boolean search(char[][] board, boolean visited[][], int x, int y, String word, int w)
    {
        char ch = word.charAt(w);
        if(board[x][y] != ch) return false;
        if(w == word.length() -1) return true;
        
        int dx[] = {0,0,1,-1}, dy[]={-1,1,0,0};        
        boolean res = false;
        for(int i = 0; i<4; i++)
        {
            int m = x + dx[i], n = y + dy[i];
            boolean inBounds = -1 < m && m < board.length && -1 < n && n < board[m].length;
            if(inBounds && !visited[m][n])
            {
                visited[x][y] = true;
                res = res || search(board, visited, m, n, word, w+1);
                visited[x][y] = false;
            }
        }
        return res;        
    }
    
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];

        boolean res = false;
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[i].length; j++)
            {
                visited[i][j] = true;
                res = res || search(board, visited, i, j, word, 0);
                visited[i][j] = false;
            }
        }
        return res; 
    }
}