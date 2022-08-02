class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=0;
        for(i=0; i<nums.length; i++)
        {
            int s=target-nums[i];
            j=Arrays.binarySearch(nums, i+1, nums.length, s);
            if(j>=0) break;
        }
        int res[]={i+1,j+1};
        return res;
    }
}