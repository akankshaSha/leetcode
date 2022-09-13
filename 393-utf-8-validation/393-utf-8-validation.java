class Solution {
    public boolean validUtf8(int[] data) {
        int i=0;
        while(i<data.length)
        {
            int n=data[i];
            int m=0;
            if(0<=n && n<128) m=1;
            else if(192<=n && n<224) m=2;
            else if(224<=n && n<240) m=3;
            else if(240<=n && n<248) m=4;
            else return false;
            for(;m>1; m--)
            {
                i++;
                if(i>=data.length) return false;
                if(128<=data[i] && data[i]<192) continue;
                else return false;
            }
            i++;
        }
        return true;
    }
}