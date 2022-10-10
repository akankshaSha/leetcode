class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";
        int i=0;
        for(; i<palindrome.length()-1; i++)
        {
            if(palindrome.charAt(i)!='a' && i!=palindrome.length()-1-i)
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1);
        }
        return palindrome.charAt(i)!='a'? palindrome.substring(0, i) + "a": palindrome.substring(0, i) + "b";
    }
}