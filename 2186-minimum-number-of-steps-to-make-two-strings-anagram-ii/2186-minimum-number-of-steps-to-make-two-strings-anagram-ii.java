class Solution {
    public int minSteps(String s, String t) {
        int f[][] = new int[2][26];
        for(int i=0; i<s.length(); i++) f[0][s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) f[1][t.charAt(i) - 'a']++;
        int count = 0;
        for(int i =0; i<26; i++) count += Math.abs(f[0][i] - f[1][i]);
        return count;
    }
}