class Solution {
    public int findDuplicate(int[] nums) {
        int fast=0, slow=0;
        do
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=0;
        while(fast!=slow)
        {
            fast=nums[fast];
            slow=nums[slow];
        }
        return slow;
    }
}