class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0, res[]=new int[queries.length], index=0;
        for(int i=0; i<nums.length; i++)
            sum+=nums[i]%2==0?nums[i]:0;
        for(int query[]: queries)
        {
            if(nums[query[1]]%2==0) sum-=nums[query[1]];
            nums[query[1]]+=query[0];
            if(nums[query[1]]%2==0) sum+=nums[query[1]];
            res[index++]=sum;
        }
        return res;
    }
}