class Solution {
    public int minimumAverageDifference(int[] nums) {
        long left [] = new long[nums.length];
        long right [] = new long[nums.length];
        
        left [0] = nums[0];
        right[right.length -1] = nums[nums.length -1];
        
        for(int i = 1; i<nums.length; i++) left[i] = left[i-1] + nums[i];
        for(int i = nums.length -2; i>-1; i--) right[i] = right[i+1] + nums[i];
        
        int minDiff = Integer.MAX_VALUE, res = 0, diff = 0;
        for(int i = 0; i < nums.length -1; i++)
        {
            int a1 = (int) Math.rint(left[i] / (i + 1));
            int a2 = (int) Math.rint(right[i + 1] / (nums.length - i -1));
            
            diff = (int) Math.abs(a1-a2);
            if(diff < minDiff)
            {
                minDiff = diff;
                res = i;
            }
        }
        
        diff = (int) Math.abs(right[0] / nums.length);
        if(diff < minDiff)
        {
            minDiff = diff;
            res = nums.length -1 ;
        }
        
        return res;
    }
}