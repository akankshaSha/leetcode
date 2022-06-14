class Solution {
    public void rotate(int[][] matrix) 
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=i; j<matrix[0].length; j++)
            {
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        
        for(int i=0; i<matrix.length; i++)
        {
            int p=0, q=matrix.length-1;
            while(p<q)
            {
                int t=matrix[i][p];
                matrix[i][p]=matrix[i][q];
                matrix[i][q]=t;
                p++;
                q--;
            }
        }
    }
}