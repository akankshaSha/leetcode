class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashSet<Integer> count[]=new HashSet [nums.length+1];
        for(int i=0; i<count.length; i++) count[i]=new HashSet<Integer>();
        for(int n: nums) count[0].add(n);
        
        HashMap <Integer, Integer> f=new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            int prevf=f.getOrDefault(nums[i], 0);
            f.put(nums[i], prevf+1);
            count[prevf+1].add(nums[i]);
            count[prevf].remove(nums[i]);
        }
        
        int res[]=new int[k];
        int j=0;
        for(int i=count.length-1; i>=0; i--)
        {
            HashSet<Integer> set=count[i];
            if(set.size()==0) continue;
            for(int e: set)
            {
                if(j==k) return res;
                res[j++]=e;
            }
        }
        return res;
    }
}