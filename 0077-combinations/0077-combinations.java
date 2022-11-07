class Solution {
    List<List<Integer>> get(int s, int n, int k, HashSet<Integer> selected)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0)
        {
            res.add(new ArrayList<>());
            return res;
        }
        for(int i =s; i<=n; i++)
        {
            if(!selected.contains(i))
            {
                selected.add(i);
                List<List<Integer>> prev = get(i,n, k-1, selected);
                for(List<Integer> group : prev) group.add(i);
                res.addAll(prev);
                selected.remove(i);
            }
        }
        return res;
    }
    public List<List<Integer>> combine(int n, int k) {
        return get(1, n, k, new HashSet<Integer>());
    }
}