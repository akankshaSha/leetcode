class Solution {
    
    public static boolean isAnagram(String s, String t)
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
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List <List<String>> groups =new ArrayList<List<String>>();
        
        for(String str : strs)
        {
            // Check if hash matches a group
            boolean matched=false;
            for(List<String> group: groups)
            {
                String match=group.get(0);
                // if yes, then add group in that string
                if(isAnagram(str, match))
                {
                    group.add(str);
                    matched=true;
                    break;
                }
            }
            
            // if no, add the string to a new group
            if(!matched)
            {
                List<String> temp=new ArrayList<String>();
                temp.add(str);
                groups.add(temp);
            }
        }
        
        return groups;
    }
}