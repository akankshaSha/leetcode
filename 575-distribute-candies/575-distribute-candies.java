class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet <Integer> h=new HashSet<>();
        for(int e: candyType) h.add(e);
        if(candyType.length/2 > h.size()) return h.size();
        return candyType.length/2;
    }
}