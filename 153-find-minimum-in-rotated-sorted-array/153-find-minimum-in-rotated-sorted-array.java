class Solution {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        if(nums[0]<=nums[right]) return nums[0];
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]>=nums[0]) left=mid+1;
            else
            {
                if(mid==nums.length-1 && nums[mid-1]>nums[mid]) return nums[mid];
                if(nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]) return nums[mid];
                else right=mid-1;
            }
        }
        return -1;
    }
}