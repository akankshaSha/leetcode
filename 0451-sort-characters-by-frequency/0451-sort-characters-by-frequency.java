class CF
{
    char c;
    int f;
    CF(char c, int f)
    {
        this.c = c;
        this.f = f;
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> f = new HashMap<>();
        for(int i = 0; i<s.length(); i++) f.put(s.charAt(i), f.getOrDefault(s.charAt(i), 0) + 1);
        
        List<CF> sub = new ArrayList<>();
        for(char c : f.keySet()) sub.add(new CF(c, f.get(c)));
        
        Collections.sort(sub, (a, b) -> Integer.compare(b.f, a.f));
        
        StringBuilder res = new StringBuilder();
        for(CF cf : sub)
        {
            for(int i = 0; i < cf.f; i++) res.append(cf.c);
        }
        return res.toString();
    }
}