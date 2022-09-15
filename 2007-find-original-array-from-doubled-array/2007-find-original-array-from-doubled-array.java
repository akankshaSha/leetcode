class Solution {
    public int[] findOriginalArray(int[] changed) {
        int empty[]=new int[0];
        if(changed.length%2!=0) return empty;
        int res[]=new int[changed.length/2], index=0;
        Arrays.sort(changed);
        
        int h[]=new int[100001];
        for(int n: changed) h[n]++;
        for(int n: changed)
        {
            if(h[n]>0)
            {
                if((2*n)<h.length && h[2*n]>0)
                {
                    h[2*n]--;
                    res[index++]=n;
                }
                else return empty;
                h[n]--;
            }
        }
        return res;
    }
}