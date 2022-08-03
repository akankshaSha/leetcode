class Solution {
    public int majorityElement(int[] nums) {
        //Boyer Moore Element
        int count=0;
        int majority=0;
        for(int i=0; i<nums.length; i++)
        {
            if(count==0)
            {
                majority=nums[i];
            }
            if(majority==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return majority;
        /*
        count=0;
        for(int e: nums)
        {
            if(majority==e) count++;
        }
        if(count>n/2) return majority
        else <majority non existing>
        */
    }
}