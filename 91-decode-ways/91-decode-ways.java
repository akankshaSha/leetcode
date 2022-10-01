class Solution {
    int cache[];
    int count(String s, int index)
    {
        if(cache[index]>=0) return cache[index];
        if(index>s.length())
        {
            cache[index]=0;
            return 0;
        }
        if(index==s.length())
        {
            cache[index]=1;
            return 1;
        }
        int tokenise1=0, tokenise2=0;
        char cur=s.charAt(index);
        if(cur>'0') tokenise1=count(s, index+1);
        if(index+1 < s.length() && cur>'0' && (cur<'2' || (cur=='2' && s.charAt(index+1)<='6')))
            tokenise2=count(s, index+2);
        cache[index]=tokenise1+tokenise2;
        return cache[index];
    }
    public int numDecodings(String s) {
        cache=new int[s.length()+1];
        Arrays.fill(cache, -1);
        return count(s, 0);
    }
}