// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
       int csum[]=new int[n];
       ArrayList <Integer> res=new ArrayList<>();
       
       csum[0]=arr[0];
       for(int i=1;i<arr.length; i++)
           csum[i]=arr[i]+csum[i-1];
           
        HashMap <Integer, Integer> map=new HashMap<>();
        for(int i=0; i<arr.length; i++)
            map.put(csum[i], i);
            
        if(map.containsKey(s))
        {
            res.add(1);
            res.add(map.get(s)+1);
            return res;
        }
        
        for(int i=0; i<csum.length; i++)
        {
            if(map.containsKey(csum[i]+s))
            {
                res.add(i+2);
                res.add(map.get(csum[i]+s)+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}