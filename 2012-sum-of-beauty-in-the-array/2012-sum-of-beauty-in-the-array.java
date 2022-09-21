class Solution {
    public int sumOfBeauties(int[] nums) {
        int lr[]=new int[nums.length], hl[]=new int[nums.length];
        hl[0]=Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++) hl[i]=Math.max(hl[i-1], nums[i-1]);
        lr[lr.length-1]=Integer.MAX_VALUE;
        for(int i=lr.length-2; i>-1; i--) lr[i]=Math.min(lr[i+1], nums[i+1]);
        
        int sum=0;
        for(int i=1; i<nums.length-1; i++)
        {
            int beauty=0;
            if(hl[i]<nums[i] && nums[i]<lr[i]) beauty=2;
            else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]) beauty=1;
            sum+=beauty;
        }
        return sum;
    }
}