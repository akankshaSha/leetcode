class Solution {
    public int getMostF(int f[])
    {
        int max=0;
        for(int i=0; i<f.length; i++)
        {
            if(f[i]>f[max]) max=i;
        }
        return max;
    }
    
    
    public int characterReplacement(String s, int k) {
        int start=0, end=0, len=0;
        int frequency[]=new int[26], mostF=0, sum=0;
        
        for(; end<s.length(); end++)
        {
            int c=s.charAt(end)-'A';
            frequency[c]++;
            if(frequency[c]>frequency[mostF]) mostF=c;
            sum++;
            while(sum-frequency[mostF]>k)
            {
                frequency[s.charAt(start)-'A']--;
                mostF=getMostF(frequency);
                start++;
                sum--;
            }
            len=Math.max(len, end-start+1);
        }
        return len;
    }
}