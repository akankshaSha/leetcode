class Solution {
    static int[] getRest(int arr[], int index)
    {
        int res[]=new int[arr.length-1];
        for(int i=0, j=0; i<arr.length; i++)
        {
            if(i==index) continue;
            res[j++]=arr[i];
        }
        return res;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> res= new ArrayList<>();
        if(nums.length==0)
        {
            res.add(new ArrayList<Integer>());
            return res;
        }
        HashSet<Integer> start=new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(start.contains(nums[i])) continue;
            List<List<Integer>> prev = permuteUnique(getRest(nums, i));
            for(List<Integer> l: prev)
            {
                l.add(nums[i]);
                res.add(l);
            }
            start.add(nums[i]);
        }
        return res;
    }
}