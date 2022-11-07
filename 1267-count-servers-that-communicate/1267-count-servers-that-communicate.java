class Solution {
    public int countServers(int[][] grid) {
        int rowCount[]=new int[grid.length];
        int colCount[] = new int[grid[0].length];
        
        for(int i =0; i<grid.length; i++)
        {
            int rCount = 0;
            for(int j = 0; j<grid[i].length; j++)
            {
                rCount += grid[i][j];
            }
            rowCount[i] = rCount;
        }
        
        for(int j =0; j<grid[0].length; j++)
        {
            int cCount = 0;
            for(int i = 0; i<grid.length; i++)
            {
                cCount += grid[i][j];
            }
            colCount[j] = cCount;
        }
        
        
        int res=0;
        
        for(int i =0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[i].length; j++)
            {
                if( grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) res++;
            }
        }
        return res;
    }
}