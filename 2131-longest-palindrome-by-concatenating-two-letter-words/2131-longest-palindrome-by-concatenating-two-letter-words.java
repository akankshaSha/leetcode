class Solution {
    public int longestPalindrome(String[] words) {
        int res=0, maidenMirrors = 0;
        HashMap<String, Integer> wordCount=new HashMap<>();
        for(String word: words) wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        for(String word: wordCount.keySet())
        {
            char a = word.charAt(0), b = word.charAt(1);
            int count = wordCount.get(word);
            if(a == b) {
                //is mirror
                maidenMirrors += count%2;
                res += count/2;
            }
            else if(a < b && wordCount.containsKey(b+""+a)) {
                //has mirror
                res += Math.min(count, wordCount.get(b+""+a));
            }
        }
        
        res *= 4;
        if(maidenMirrors > 0) res += 2;
        return res;
    }
}