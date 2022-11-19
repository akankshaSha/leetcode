class Solution {
    public List<Integer> grayCode(int n) {
        if(n==1) return Arrays.asList(0, 1);
        List<Integer> prev = new ArrayList<>();
        prev = grayCode(n-1);
        List<Integer> res = new ArrayList<>();
        for(int e : prev) res.add(e);
        for(int i = prev.size()-1; i>-1; i--) res.add(prev.get(i) + (int)Math.pow(2, n-1));
        return res;
    }
}