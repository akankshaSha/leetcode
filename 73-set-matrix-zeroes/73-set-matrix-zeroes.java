class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> Rows=new ArrayList<>();
        ArrayList<Integer> Cols=new ArrayList<>();
        
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    Rows.add(i);
                    Cols.add(j);
                }
            }
        }
        
        for(int row: Rows)
        {
            for(int j=0; j<matrix[0].length; j++) matrix[row][j]=0;
        }
        
        for(int col: Cols)
        {
            for(int i=0; i<matrix.length; i++) matrix[i][col]=0;
        }
    }
}