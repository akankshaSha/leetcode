class Solution {
    
    public static List<List<Integer>> cSum(int[] candidates, int target, int index)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(target==0)
        {
            res.add(new ArrayList<Integer>());
            return res;
        }
        for(int i=index; i<candidates.length; i++)
        {
            if(candidates[i]>target) continue;
            List<List<Integer>> prev =cSum(candidates, target-candidates[i], i);
            for(List<Integer> l: prev)
            {
                l.add(candidates[i]);
                res.add(l);
            }
        }
        return res;
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        return (cSum(candidates, target, 0));
    }
}