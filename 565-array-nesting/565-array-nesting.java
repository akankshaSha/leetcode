class Solution {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> set;
        int res=0;
        boolean visited[]=new boolean[nums.length];
        for(int k=0; k<nums.length; k++)
        {
            int i=nums[k], count=1;
            if(!visited[k])
            {
                while(i!=k)
                {
                    visited[i]=true;
                    i=nums[i];
                    count++;
                }
            }
            res=Math.max(res, count);
        }
        return res;
    }
}