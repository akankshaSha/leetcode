class Solution {
    int cache[];
    int go(int [] nums, int index)
    {
        int res=nums.length;
        if(index==nums.length-1) return 0;
        if(cache[index]>0) return cache[index];
        for(int step=1; step<=nums[index]; step++)
        {
            int jump=index+step;
            if(jump<nums.length) res=Math.min(res, go(nums, jump));
        }
        cache[index]=res+1;
        return res+1;
    }
    public int jump(int[] nums) {
        cache=new int[nums.length];
        Arrays.fill(cache, -1);
        return go(nums, 0);
    }
}