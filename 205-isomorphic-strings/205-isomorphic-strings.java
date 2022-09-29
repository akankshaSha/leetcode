class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> st=new HashMap<>();
        HashMap<Character, Character> ts=new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            char a=s.charAt(i);
            char b=t.charAt(i);
            if((st.containsKey(a) && st.get(a)!=b) || (ts.containsKey(b) && ts.get(b)!=a)) return false;
            st.put(a, b);
            ts.put(b, a);
        }
        return true;
    }
}