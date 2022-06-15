class Solution {
    public int[][] transpose(int[][] matrix) {
        int [][] T=new int[matrix[0].length][matrix.length];
        for(int i=0; i<T.length; i++)
        {
            for(int j=0; j<T[i].length; j++)
            {
                T[i][j]=matrix[j][i];
            }
        }
        return T;
    }
}