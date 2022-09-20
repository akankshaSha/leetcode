class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums2.length+1][nums1.length+1], maxLen=0;
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[i].length; j++)
            {
                if(nums2[i-1]==nums1[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                maxLen=Math.max(maxLen, dp[i][j]);
            }
        }        
        return maxLen;
    }
}