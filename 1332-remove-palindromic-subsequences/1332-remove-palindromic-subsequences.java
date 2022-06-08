class Solution {
    public int removePalindromeSub(String s) {
        int p=0, q=s.length()-1;
        while(p<q)
        {
            if(s.charAt(p++)!=s.charAt(q--)) return 2;
        }
        return 1;
    }
}