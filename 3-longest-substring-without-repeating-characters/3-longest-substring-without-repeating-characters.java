class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0, end=0, length=0;
        HashSet<Character> set=new HashSet<>();
        for(; end<s.length(); end++)
        {
            char c=s.charAt(end);
            while(set.contains(c))
            {
                set.remove(s.charAt(start));
                start++;
                if(start==end) break;
            }
            set.add(c);
            length=Math.max(length, end-start+1);
        }
        return length;
    }
}