class Solution {
    public boolean closeStrings(String word1, String word2) {
        //1. should be of same length
        if(word1.length() != word2.length()) return false;
        
        HashMap<Character, Integer> f1 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++)
            f1.put(word1.charAt(i), f1.getOrDefault(word1.charAt(i), 0) + 1);
                   
        HashMap<Character, Integer> f2 = new HashMap<>();
        for(int i = 0; i < word2.length(); i++)
            f2.put(word2.charAt(i), f2.getOrDefault(word2.charAt(i), 0) + 1);
        //2. should be composed of the same letters
        for(char one : f1.keySet()) if(!f2.keySet().contains(one)) return false;
        //3. should have a similar frequency map (same set of values duplicates included)
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int one : f1.values()) count.put(one, count.getOrDefault(one, 0) + 1);
        for(int two : f2.values())
        {
            if(!count.containsKey(two)) return false;
            if(count.get(two) <= 0) return false;
            count.put(two, count.get(two) -1);
        }
        return true;
    }
}