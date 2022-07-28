public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev=0;
        int two31=(int)(Math.pow(2, 31))+1;
        
        for(int i=0; i<32; i++)
        {
            int msb=n&two31;
            rev=rev>>1;
            if((rev&two31)!=0) rev=rev-two31;
            rev=rev|msb;
            n=n<<1;
        }
        
        return rev;
    }
}