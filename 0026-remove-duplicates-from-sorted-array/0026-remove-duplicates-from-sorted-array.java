class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0, i = 0;
        while(i<nums.length-1)
        {
            if(nums[i] == -101) return k;
            if(nums[i+1] == nums[i])
            {
                int j = i+1;
                for(; j<nums.length -1; j++) nums[j] = nums[j+1];
                nums[j] = -101;
            }
            else
            {
                i++;
                k++;
            }
        }
        if(i == nums.length -1 && nums[i] != -101) return k+1;
        return k;
    }
}