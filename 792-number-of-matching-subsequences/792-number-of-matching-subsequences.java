class Solution {
    static boolean isSubSequnce(String a, String b)
    {
        if(b.length() > a.length()) return false;
        int j=0;
        for(int i=0; i<a.length(); i++)
        {
            if(j==b.length()) return true;
            if(a.charAt(i)==b.charAt(j)) j++;
        }
        if(j==b.length()) return true;
        return false;
    }
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        HashSet <String>True=new HashSet<>();
        HashSet <String>False=new HashSet<>();
        for(String word: words)
        {
            if(!False.contains(word) && (True.contains(word) || isSubSequnce(s, word)))
            {
                count++;
                True.add(word);
            }
            else False.add(word);
        }
        return count;
    }
}