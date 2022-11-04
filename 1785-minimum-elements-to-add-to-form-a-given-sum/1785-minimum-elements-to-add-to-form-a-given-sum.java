class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        //1. sum(nums)
        long sum=0;
        for(int num : nums) sum+=num;
        //2. extra required
        long req=goal-sum;
        req=Math.abs(req);
        //3. count the number of chunks
        long res=req/limit;
        if(req%limit > 0) res++;
        return (int)res;        
    }
}