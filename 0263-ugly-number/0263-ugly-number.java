class Solution {
    int consume(int n, int k)
    {
        if(n == 0) return n;
        if(n % k != 0) return n;
        return consume(n/k, k);
    }
    public boolean isUgly(int n) {
        int r = consume(n, 2);
        r = consume(r, 3);
        r = consume(r, 5);
        return r == 1;
    }
}