class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char str[] = s.toCharArray();
        int p=0, q=str.length-1;
        while(p<=q) {
            if(!vowels.contains(str[p])) p++;
            else if(!vowels.contains(str[q])) q--;
            else 
            {
                char t = str[p];
                str[p] = str[q];
                str[q] = t;
                p++;
                q--;
            }
        }
        String res = new String(str);
        return res;
    }
}