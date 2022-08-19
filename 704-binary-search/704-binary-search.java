class Solution {
    public int search(int[] nums, int target) {
        int p=0, q=nums.length-1;
        while(p<=q)
        {
            int r=p+(q-p)/2;
            if(nums[r]>target) q=r-1;
            else if(nums[r]<target) p=r+1;
            else return r;
        }
        return -1;
    }
}