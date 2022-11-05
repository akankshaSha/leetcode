class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low=0, high=nums.length-1, mid=0;
        while(low <= high)
        {
            mid = low + (high-low)/2;
            int one=mid, two=mid;
            if(mid == 0) two = 1;
            else if(mid == nums.length-1) one = two -1;
            else
            {
                if(nums[mid-1] == nums[mid]) one = two -1;
                else if(nums[mid+1] == nums[mid]) two = one +1;
                else return nums[mid];
            }
            if(nums[one] != nums[two]) return nums[mid];
            
            if(two % 2 == 0) high = mid -1;
            else low = mid +1;
        }
        return -1;
    }
}