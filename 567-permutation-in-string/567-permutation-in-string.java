class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> charFrequency=new HashMap<>();
        for(int i=0; i<s1.length(); i++)
        {
            charFrequency.put(s1.charAt(i), charFrequency.getOrDefault(s1.charAt(i), 0)+1);
        }
        
        for(int i=0; i<s2.length()-s1.length()+1; i++)
        {
            HashMap<Character, Integer> chf=new HashMap<>(charFrequency);
            boolean isPerm=true;
            for(int j=i; j<i+s1.length(); j++)
            {
                char ch=s2.charAt(j);
                if(!chf.containsKey(ch) || chf.get(ch)==0) 
                {
                    isPerm=false;
                    break;
                }
                else chf.put(ch,chf.get(ch)-1);
            }
            if(isPerm) return true;
        }
        
        return false;
    }
}