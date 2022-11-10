class Solution {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(res.length() <= 0) res.append(c);
            else
            {
                char r = res.charAt(res.length() - 1);
                if (c == r)
                {
                    res.deleteCharAt(res.length() - 1);
                }
                else res.append(c);
            }
        }
        
        return res.toString();
    }
}