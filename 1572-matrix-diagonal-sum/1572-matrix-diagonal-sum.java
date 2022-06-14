class Solution {
    public int diagonalSum(int[][] mat) {
        int sum1=0, sum2=0;
        for(int i=0; i<mat.length; i++)
        {
            for(int j=0; j<mat.length; j++)
            {
                if(i==j || i==mat.length-1-j) sum1+=mat[i][j];
            }
        }
        return sum1;
    }
}