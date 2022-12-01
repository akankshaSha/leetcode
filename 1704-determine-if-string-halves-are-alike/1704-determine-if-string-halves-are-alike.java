class Solution {
    public boolean halvesAreAlike(String s) {
        int c1 = 0, c2 = 0;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        for(; i<s.length()/2; i++) if(vowels.contains(s.charAt(i))) c1++;
        for(; i<s.length(); i++) if(vowels.contains(s.charAt(i))) c2++;
        return c1 == c2;
    }
}