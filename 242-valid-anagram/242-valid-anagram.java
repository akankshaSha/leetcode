class Solution {
    public boolean isAnagram(String s, String t)
    {
        if(s.length()!=t.length()) return false;
        char h[]=new char [26];
        for(int i=0; i<s.length(); i++)
        {
            h[s.charAt(i)-97]++;
        }
        
        for(int i=0; i<t.length(); i++)
        {
            if(h[t.charAt(i)-97]<=0) return false;
            h[t.charAt(i)-97]--;
        }
        return true;
    }
}