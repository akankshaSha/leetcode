class Solution {
    
    int overlap(int img1[][], int img2[][], int x1, int y1, int x2, int y2)
    {
        int res=0;
        for(int i1=x1, i2=x2; i1<img1.length && i2<img2.length; i1++, i2++)
        {
            for(int j1=y1, j2=y2; j1<img1[i1].length && j2<img2[i2].length; j1++, j2++)
            {
                if(img1[i1][j1]==1 && img2[i2][j2]==1) res++;
            }
        }
        return res;
    }
    
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res=0;
        
        for(int i1=0; i1<img1.length; i1++)
        {
            for(int j1=0; j1<img1[i1].length; j1++)
            {
                for(int i2=0; i2<img2.length; i2++)
                {
                    for(int j2=0; j2<img2[i2].length; j2++)
                    {
                        res=Math.max(res, overlap(img1, img2, i1, j1, i2, j2));
                    }
                }
            }
        }
        
        return res;
    }
}