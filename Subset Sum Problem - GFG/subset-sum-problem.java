// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    /*
    recursive solution:
    static boolean iss(int arr[], int index, int sum)
    {
        if(index==arr.length) return false;
        if(sum==arr[index]) return true;
        if(arr[index]> sum) return iss(arr, index+1, sum);
        boolean add= iss(arr, index+1, sum-arr[index]);
        boolean leave= iss(arr, index+1, sum);
        return add || leave;
    }
    */
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean M[][]=new boolean[sum+1][arr.length];
        
        for(int s=0; s<=sum; s++) 
            M[s][arr.length-1]= arr[arr.length-1]==s;
    
        for(int i=arr.length-2; i>=0; i--)
        {
            for(int s=0; s<=sum; s++)
            {
                boolean one=M[s][i+1];
                boolean two=false;
                boolean three= arr[i]==s;
                if(s-arr[i]>0) two=M[s-arr[i]][i+1];
                M[s][i]= one || two || three;
            }
        }
        return M[sum][0];
    }
}