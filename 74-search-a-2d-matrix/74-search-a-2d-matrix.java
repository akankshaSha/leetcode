class Solution {
    
    public boolean binarySearch(int[] arr, int target)
    {
        int p=0, q=arr.length-1, r;
        while(p<=q) 
        {
            r=p+(q-p)/2;
            if(arr[r]<target) p=r+1;
            else if(arr[r]>target) q=r-1;
            else return true;
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++)
        {
            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1])
            {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}