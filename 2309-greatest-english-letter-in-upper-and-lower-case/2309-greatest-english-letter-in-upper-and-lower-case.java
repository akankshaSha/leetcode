class Solution {
    public String greatestLetter(String s) {
        int count1 [] = new int[26];
        int count2 [] = new int[26];
        for(int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if('a' <= c && c <='z') count1[c - 'a']++;
            if('A' <= c && c <='Z') count2[c - 'A']++;
        }
        
        
        for(int i = 25; i>=0; i--)
            if(count1[i] > 0 && count2[i] > 0) return Character.toString(i + 'A');
        return "";
    }
}