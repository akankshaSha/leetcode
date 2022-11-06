class Solution {
    public String orderlyQueue(String s, int k) {
        String res = s;
        if(k == 1) 
        {
            for(int i=0; i<s.length(); i++)
            {
                String p = s.substring(i) + s.substring(0, i);
                if(res.compareTo(p) > 0) res = p;
            }
        }
        else
        {
            char ordr [] = s.toCharArray();
            Arrays.sort(ordr);
            res = new String(ordr);
        }
        return res;
    }
}