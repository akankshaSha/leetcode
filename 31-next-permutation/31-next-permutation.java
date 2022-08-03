class Solution {
    public void nextPermutation(int[] nums) {
        int anmly=0;
        for(anmly=nums.length-1; anmly>0; anmly--)
        {
            if(nums[anmly]>nums[anmly-1]) break;
        }
        anmly--;
        
        Arrays.sort(nums, anmly+1, nums.length);
        if(anmly==-1) return;
        int next=0;
        for(next=anmly+1; next<nums.length; next++)
        {
            if(nums[anmly]<nums[next]) break;
        }
        int t=nums[anmly];
        nums[anmly]=nums[next];
        nums[next]=t;
    }
}