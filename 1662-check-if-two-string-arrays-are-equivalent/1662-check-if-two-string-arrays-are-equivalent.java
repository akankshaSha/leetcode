class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1=new StringBuilder(), w2=new StringBuilder();
        for(String word: word1) w1.append(word);
        for(String word: word2) w2.append(word);
        if(w1.length() != w2.length()) return false;
        for(int i=0; i<w1.length(); i++) if(w1.charAt(i)!=w2.charAt(i)) return false;
        return true;
    }
}