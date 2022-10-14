class Solution {
    public int islandPerimeter(int[][] grid) {
        int res=0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]==1)
                {
                    int dx[]={0,1,0,-1};
                    int dy[]={1,0,-1,0};
                    for(int k=0; k<4; k++)
	                {
		                int x=i+dx[k], y=j+dy[k];
		                boolean inBounds= -1<x && x<grid.length && -1<y && y<grid[0].length;
		                if(!inBounds || inBounds && grid[x][y]==0) res++;
	                }
                    
                }
            }
        }
        return res;
    }
}