class Solution {
    public List<List<Integer>> fill(int[] nums,int index)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(index==nums.length)
        {
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>>right=fill(nums, index+1);
        res.addAll(right);
        for(List<Integer> list: right)
        {
            List<Integer> aux=new ArrayList<>(list);
            aux.add(nums[index]);
            res.add(aux);
        }
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        boolean visited[]=new boolean[nums.length];
        return fill(nums, 0);
    }
}