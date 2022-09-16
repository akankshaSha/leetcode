/*
class Solution {
    int ms(int[]nums, int[]multipliers, int left, int index)
    {
        int right=nums.length-(index-left+1);
        if(left>right || index==multipliers.length) return 0;
        int start=ms(nums, multipliers, left+1, index+1) + nums[left]*multipliers[index];
        int end=ms(nums, multipliers, left, index+1) + nums[right]*multipliers[index];
        return Math.max(start, end);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int ms[][]=new int[nums.length][multipliers.length+1];
        for(int i=multipliers.length-1; i>-1; i--)
        {
            for(int l=0; l<nums.length; l++)
            {
                int r=nums.length-(i-l+1);
                if(l>r) continue;
                int start=0, end=0;
                if(l+1<nums.length) start=ms[l+1][i+1]+nums[l]*multipliers[i];
                if(r<nums.length) end=ms[l][i+1]+nums[r]*multipliers[i];
                ms[l][i]=Math.max(start, end);
            }
        }
        return ms[0][0];
    }
}
*/

class Solution {
    int N, M;
    public int maximumScore(int[] nums, int[] multipliers) {
        N = nums.length;
        M = multipliers.length;
	    return helper(nums, multipliers, 0, 0, new Integer[M][M]);
    }

    private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
	    int right = N - 1 - (index - left);
	    if (index == M) return 0;

	    if (dp[left][index] != null) return dp[left][index];

	    int res = Math.max(
            nums[left] * multipliers[index] + helper(nums, multipliers, left+1, index+1, dp), 
            nums[right] * multipliers[index] + helper(nums, multipliers, left, index+1, dp));

        dp[left][index] = res;
	    return res;
    }
}