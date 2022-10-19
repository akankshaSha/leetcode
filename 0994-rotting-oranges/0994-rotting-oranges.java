class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten=new LinkedList<>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
                if(grid[i][j]==2) rotten.offer(new int[] {i, j});
        }
        
        int res=0;
        while(!rotten.isEmpty())
        {
            List<int[]> newRots=new ArrayList<>();
            while(!rotten.isEmpty())
            {
                int dx[]={0, 1, 0, -1};
                int dy[]={1, 0, -1, 0};
                int r[]=rotten.poll();
                for(int i=0; i<4; i++)
                {
                    int x=r[0]+dx[i], y=r[1]+dy[i];
                    boolean inBounds= -1<x && x<grid.length && -1<y && y<grid[0].length;
                    if(inBounds && grid[x][y]==1) newRots.add(new int[] {x, y});
                }
            }
            
            for(int[]r  : newRots)
            {
                grid[r[0]][r[1]]=2;
                rotten.offer(r);
            }
            if(!rotten.isEmpty()) res++;            
        }
        for(int r[]: grid) for(int e: r) if(e==1) return -1;
        return res;
    }
}