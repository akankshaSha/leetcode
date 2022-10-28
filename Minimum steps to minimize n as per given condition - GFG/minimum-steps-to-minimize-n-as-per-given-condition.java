//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mem[];
    public int minStep(int N) 
	{
	    if(mem[N]!=0) return mem[N];
	    if(N==1) return 0;
	    int two=Integer.MAX_VALUE, three=Integer.MAX_VALUE;
	    if(N%2==0) two=minStep(N/2);
	    if(N%3==0) three=minStep(N/3);
	    mem[N]= Math.min(minStep(N-1), Math.min(two, three))+1;
	    return mem[N];
	}
	
	public int minSteps(int N) 
	{ 
	    mem=new int[N+1];
	    return minStep(N);
	} 
}
