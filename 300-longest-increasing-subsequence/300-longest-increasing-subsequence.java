class Solution {
    int mem[];
    int len(int nums[], int index)
    {
        if(mem[index]!=-1) return mem[index];
        int maxLen=0;
        for(int i=index+1; i<nums.length; i++)
        {
            if(nums[i]>nums[index])
            {
                maxLen=Math.max(maxLen, len(nums, i));
            }
        }
        mem[index]=maxLen+1;
        return mem[index];
    }
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        mem=new int[nums.length];
        Arrays.fill(mem, -1);
        for(int i=0; i<nums.length; i++) maxLen=Math.max(maxLen, len(nums, i));
        return maxLen;
    }
}