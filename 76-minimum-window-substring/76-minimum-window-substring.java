class Solution {
    public boolean inclusion(HashMap<Character, Integer>ft, HashMap<Character, Integer>fs)
    {
        for(char c: ft.keySet())
        {
            if(fs.get(c)<ft.get(c)) return false;
        }
        return true;
    }
    
    
    public String minWindow(String s, String t) {
        int start=0, end=0, minLen=Integer.MAX_VALUE;
        String res="";
        HashMap<Character, Integer> ft=new HashMap<>();
        HashMap<Character, Integer> fs=new HashMap<>();
        for(int i=0; i<t.length(); i++)
        {
            char c=t.charAt(i);
            ft.put(c, ft.getOrDefault(c, 0)+1);
            fs.put(c, 0);
        }
        
        for(; end<s.length(); end++)
        {
            char c=s.charAt(end);
            if(fs.containsKey(c)) fs.put(c, fs.get(c)+1);
            while(inclusion(ft, fs))
            {
                int len=end-start+1;
                if(len<minLen)
                {
                    minLen=len;
                    res=s.substring(start, end+1);
                }
                char ch=s.charAt(start);
                if(fs.containsKey(ch)) fs.put(ch, fs.get(ch)-1);
                start++;
            }
        }
        return res;
    }
}