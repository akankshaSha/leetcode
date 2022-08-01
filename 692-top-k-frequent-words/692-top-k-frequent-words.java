import java.util.*;
class Word
{
    String word;
    int frequency;
    Word(String word, int frequency)
    {
        this.word=word;
        this.frequency=frequency;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> heap=new PriorityQueue<>(new Comparator<Word>() {

            @Override
            public int compare(Word w1, Word w2) {
                if(w1.frequency<w2.frequency) return -1;
                if(w1.frequency>w2.frequency) return 1;
                return w2.word.compareTo(w1.word);
            }
            
        });
        
        HashMap<String, Integer> wordFrequency=new HashMap<>();
        for(String word: words)
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0)+1);
        
        for(String word: wordFrequency.keySet())
        {
            heap.add(new Word(word, wordFrequency.get(word)));
            if(heap.size()>k) heap.poll();
        }
        
        List<String> res=new ArrayList<>();
        while(heap.size()>0) res.add(0,heap.poll().word);
        return res;
    }
}