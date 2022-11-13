class Solution {
    
    public String reverseWords(String s) {
        ArrayList<String> words=new ArrayList<>();
        s=s.trim();
        s+=" ";
        int j=0;
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i)==' ' && i!=j)
            {
                words.add(s.substring(j, i));
                j=i;
            }
            if(s.charAt(j)==' ') j++;
        }
        String rev="";
        for(String word: words)
        {
            rev=word+" "+rev;
        }
        return rev.trim();
    }
}