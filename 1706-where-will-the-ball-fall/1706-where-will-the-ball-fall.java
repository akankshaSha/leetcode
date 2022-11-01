class Solution {
    int fall(int grid[][], int j)
    {
        for(int i=0; i<grid.length; i++)
        {
            boolean inBounds = -1<j && j<grid[i].length;
            if(!inBounds) return -1;
            if(grid[i][j] == 1) {
                if(j+1 >= grid[i].length || grid[i][j+1]==-1) return -1;
                j++;
            }
            else {
                if(j-1 < 0 || grid[i][j-1]== 1) return -1;
                j--;
            }
        }
        return j;
    }
    public int[] findBall(int[][] grid) {
        int res[]=new int[grid[0].length];
        for(int j=0; j<res.length; j++) res[j]=fall(grid, j);
        return res;
    }
}