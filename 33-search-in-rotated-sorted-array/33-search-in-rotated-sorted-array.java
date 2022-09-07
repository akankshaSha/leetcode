class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1, ε=nums.length-1;
        if(nums[0]==target) return 0;
        if(nums[ε]==target) return ε;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]>=nums[0])
            {
                if(nums[mid]<target) left=mid+1;
                else if(nums[mid]>target)
                {
                    if(target<nums[0]) left=mid+1;
                    else right=mid-1;
                }
                else return mid;
            }
            else if(nums[mid]<=nums[ε])
            {
                if(nums[mid]>target) right=mid-1;
                else if(nums[mid]<target)
                {
                    if(target<nums[ε]) left=mid+1;
                    else right=mid-1;
                }
                else return mid;
            }
            else return -1;
        }
        return -1;
    }
}