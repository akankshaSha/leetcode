class Solution {    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String, List<String>> map=new HashMap<>();
        
        for(String str: strs)
        {
            char chArray[]=str.toCharArray();
            Arrays.sort(chArray);
            String s=new String(chArray);
            List<String> group=new ArrayList<>();
            if(map.containsKey(s))
            {
                group=map.get(s);
            }
            group.add(str);
            map.put(s, group);
        }
        
        for(List<String> groups: map.values())
        {
            res.add(groups);
        }
        
        return res;
    }
}