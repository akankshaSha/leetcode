class Cordinate
{
    int x;
    int y;
    Cordinate(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}


class Solution {
    
    public HashSet<Cordinate> getTwos(int [][] grid)
    {
        HashSet<Cordinate> res =new HashSet<>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]==2) res.add(new Cordinate(i,j));
            }
        }
        return res;
    }
    
    public boolean fillAdj(int x, int y, int [][] grid)
    {
        boolean flag=false;
        if(x+1<grid.length && grid[x+1][y]==1) 
        {
            grid[x+1][y]=2;
            flag=true;
        }
        if(x-1>-1 && grid[x-1][y]==1) 
        {
            grid[x-1][y]=2;
            flag=true;
        }
        if(y+1<grid[0].length && grid[x][y+1]==1) 
        {
            grid[x][y+1]=2;
            flag=true;
        }
        if(y-1>-1 && grid[x][y-1]==1) 
        {
            grid[x][y-1]=2;
            flag=true;
        }
        return flag;
    }
    
    public boolean isRotten(int grid[][])
    {
        for(int row[]:grid)
        {
            for(int e: row) if(e==1) return false;
        }
        return true;
    }
    
    public int orangesRotting(int[][] grid) {
        HashSet<Cordinate> twos=getTwos(grid);
        if(isRotten(grid)) return 0;
        if(twos.size()==0) return -1;
        int count=0;
        while(!twos.isEmpty())
        {
            if(isRotten(grid)) return count;
            boolean gridChanged=false;
            for(Cordinate p: twos)
            {
                boolean change= fillAdj(p.x, p.y, grid);
                gridChanged=gridChanged || change;
                grid[p.x][p.y]=0;
            }
            if(!gridChanged) return -1;
            twos=getTwos(grid);
            count++;
        }
        return count;
    }
}