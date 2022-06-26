class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1) return 1;
        int prev=findTheWinner(n-1, k);
        return (k-1 + prev)%n+1;
    }
}