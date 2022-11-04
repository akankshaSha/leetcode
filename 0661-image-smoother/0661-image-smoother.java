class Solution {
    public int[][] imageSmoother(int[][] img) {
        int res[][]=new int[img.length][img[0].length];
        int dx[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1}, dy[] = {-1, 0, 1, -1, 0, 1, 1, 0, -1};
        for(int i=0; i<img.length; i++)
        {
            for(int j=0; j<img[i].length; j++)
            {
                int sum=0, count=0;
                for(int k=0; k<9; k++)
                {
                    int x = i + dx[k], y = j + dy[k];
                    boolean inBounds = -1<x && x<img.length && -1<y && y<img[x].length;
                    if (inBounds)
                    {
                        sum += img[x][y];
                        count++;
                    }
                }
                res[i][j] = sum/count; 
            }
        }
        
        return res;
    }
}