class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
        for(String word: words)
        {
            HashMap<Character, Character> patternWord=new HashMap<>();
            HashMap<Character, Character> wordPattern=new HashMap<>();
            
            if(word.length()!=pattern.length()) continue;
            boolean hasViolated=false;
            for(int i=0; i<word.length(); i++)
            {
                char w=word.charAt(i);
                char p=pattern.charAt(i);
                if(wordPattern.containsKey(w) && wordPattern.get(w)!=p) 
                {
                    hasViolated=true;
                    break;
                }
                if(patternWord.containsKey(p) && patternWord.get(p)!=w)
                {
                    hasViolated=true;
                    break;
                }
                wordPattern.put(w, p);
                patternWord.put(p, w);
            }
            if(!hasViolated) res.add(word);
        }
        return res;
    }
}