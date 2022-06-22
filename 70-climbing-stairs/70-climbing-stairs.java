class Solution {
    static int m[]=new int[46];
    public static int climbStairs(int n) {
        if(n==1 || n==0) return 1;
        if(m[n]==0)
            m[n] = climbStairs(n-1) + climbStairs(n-2);
        return m[n];
    }
}