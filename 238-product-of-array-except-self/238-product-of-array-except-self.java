class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1, nonZeroProduct=1;
        int zeroCount=0;
        for(int num: nums)
        {
            if(num!=0) nonZeroProduct*=num; 
            product*=num;
            if(num==0) zeroCount++;
        }
        
        if(zeroCount>1) nonZeroProduct=0;
        
        int res[]=new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0) res[i]=nonZeroProduct;
            else res[i]=product/nums[i];
        }
        return res;
    }
}