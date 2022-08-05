class Solution {
    int combiSums[]=new int[2000];
    int sum(int[] nums, int target)
    {
        if(target==0) return 1;
        if(target<0) return 0;
        int res=0;
        for(int num:nums) 
        {
            if(target-num<0) continue;
            int s=0;
            if(combiSums[target-num]!=-1) s=combiSums[target-num];
            else s=combiSums[target-num]=sum(nums, target-num);
            res+=s;
        }
        return res;
    }
    public int combinationSum4(int[] nums, int target) {
        for(int i=0; i<combiSums.length; i++) combiSums[i]=-1; 
        return sum(nums,target);
    }
}