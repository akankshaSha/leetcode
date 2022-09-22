class Solution {
    String reverse(String word)
    {
        String res="";
        for(int i=word.length()-1; i>-1; i--)
        {
            res+=word.charAt(i);
        }
        return res;
    }
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        String res="";
        for(String word: words)
        {
            res+=reverse(word)+" ";
        }
        return res.trim();
    }
}