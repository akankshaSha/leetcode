class Solution {
    
    public void demark(int i, int j, char[][] grid)
    {
        grid[i][j]='0';
        if(i+1<grid.length && grid[i+1][j]=='1') demark(i+1, j, grid);
        if(i-1>-1 && grid[i-1][j]=='1') demark(i-1, j, grid);
        if(j+1<grid[0].length && grid[i][j+1]=='1') demark(i, j+1, grid);
        if(j-1>-1 && grid[i][j-1]=='1') demark(i, j-1, grid);
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    demark(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}