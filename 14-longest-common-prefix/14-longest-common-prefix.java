class Solution {
    public String longestCommonPrefix(String[] strs)
    {
        if(strs.length==1) return strs[0];
        
        StringBuilder prefix=new StringBuilder("");
        String first=strs[0];
        for(int i=0; i<first.length(); i++)
        {
            char c=first.charAt(i);
            boolean contained=true;
            for(int j=1; j<strs.length; j++)
            {
                String next=strs[j];
                if(next.length()<=i || next.charAt(i)!=c)
                {
                    contained=false;
                    break;
                }                
            }
            if(contained) prefix.append(c);
            else break;
        }
        return prefix.toString();
    }
}