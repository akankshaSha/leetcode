class Solution {
    
    public void customSort(int arr[], int cmpr[])
    {
        for(int i=0; i<arr.length ;i++)
        {
            for(int j=0; j<arr.length-i-1; j++)
            {
                if(cmpr[j]>cmpr[j+1])
                {
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                    t=cmpr[j];
                    cmpr[j]=cmpr[j+1];
                    cmpr[j+1]=t;
                }
            }
        }
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int str[]=new int[mat.length];
        int indexes[]=new int[mat.length];
        for(int i=0; i<mat.length; i++)
        {
            int s=0;
            for(int j=0; j<mat[i].length; j++)
            {
                if(mat[i][j]==1) s++;
                else break;
            }
            str[i]=s;
            indexes[i]=i;
        }
        
        customSort(indexes, str);        
        int res[]=new int [k];
        for(int i=0; i<k; i++)
            res[i]=indexes[i];
        return res;
    }
}