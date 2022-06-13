class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        int p=0, q=1, r=2;
        for(; r<s.length(); p++, q++, r++)
        {
            char a=s.charAt(p), b=s.charAt(q), c=s.charAt(r);
            if(a!=b && b!=c && c!=a) count++;
        }
        return count;
    }
}