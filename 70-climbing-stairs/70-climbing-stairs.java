class Solution {
    public static int climbStairs(int n) {
        int m[]=new int[n+1];
        m[0]=m[1]=1;
        for(int i=2; i<=n; i++)
            m[i]=m[i-1]+m[i-2];
        return m[n];
    }
}