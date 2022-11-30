class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for(int e : arr) f.put(e, f.getOrDefault(e, 0) +1);
        
        HashSet<Integer> set = new HashSet<>();
        for(int occurance : f.values()) if(!set.add(occurance)) return false;
        return true;
    }
}