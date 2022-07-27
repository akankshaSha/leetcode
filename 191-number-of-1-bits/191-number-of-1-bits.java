public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int setBits=0;
        while(true)
        {
            if(n==0) break;
            n=n&(n-1);
            setBits++;
        }
        return setBits;
    }
}