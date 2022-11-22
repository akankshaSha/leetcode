class Solution {
    int cache[];
    public int numSquare(int n) {
        if(n == 0) return 0;
        if(cache[n] != 0) return cache[n];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++)
        {
            res = Math.min(res, numSquare(n - i*i) +1);
        }
        cache[n] = res;
        return cache[n];
    }
    public int numSquares(int n) {
        cache = new int[n+1];
        return numSquare(n);
    }
}