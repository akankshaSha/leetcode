class Solution {
    public String tictactoe(int[][] moves) {
        char grid[][]=new char[3][3];
        int k=0;
        for(k=0; k<moves.length; k++)
        {
            int x = moves[k][0], y = moves[k][1];
            char marker = k%2==0 ? 'X' : 'O';
            grid[x][y] = marker;
            String winner = marker=='X' ? "A" : "B";
            if(grid[0][y] == grid[1][y] && grid[1][y] == grid[2][y]) return winner;
            if(grid[x][0] == grid[x][1] && grid[x][1] == grid[x][2]) return winner;
            if(x-y == -1 || x-y == 1) continue;
            if(x == y && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) return winner;
            if(x+y == 2 && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2]) return winner;
        }
        if(k==9) return "Draw";
        return "Pending";
    }
}