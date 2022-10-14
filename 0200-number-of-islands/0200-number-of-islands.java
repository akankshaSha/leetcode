class Solution {
    void dfs(boolean visited[][], char grid[][], int n, int m)
    {
        visited[n][m]=true;
        int dx[]={1, 0, -1, 0};
        int dy[]={0, 1, 0, -1};
        for(int i=0; i<4; i++)
        {
            int x=n+dx[i], y=m+dy[i];
            boolean inBounds= -1<x && x<grid.length && -1<y && y<grid[0].length;
            if(inBounds && grid[x][y]=='1' && !visited[x][y]) dfs(visited, grid, x, y);
        }
    }
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    dfs(visited, grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
}