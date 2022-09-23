class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        
        long ans =0;
        for(int i=1; i<=n; i++){
            ans = (((ans<<(1+(int)(Math.log(i) / Math.log(2))))%mod)+i)%mod;
        }
        return (int)ans;
    }
}