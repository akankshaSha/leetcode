class Solution {
    public boolean canJump(int[] nums) {
        boolean cache[]=new boolean[nums.length];
        cache[cache.length-1]=true;
        for(int i=cache.length-2; i>=0; i--)
        {
            for(int j=1; j<=nums[i]; j++) 
            {
                if(i+j<nums.length && cache[i+j])
                {
                    cache[i]=true;
                    break;
                }
            }
        }
        return cache[0];
    }
}

//stupid solution
/*
class Solution {
    int cache[];
    public boolean cj(int[] nums, int index) {
        if(index==nums.length-1) return true;
        if(cache[index]!=-1) return cache[index]==1?true:false;
        boolean res=false;
        for(int i=1; i<=nums[index]; i++) res=res||cj(nums, index+i);
        cache[index]=res?1:0;
        return res;
    }
    public boolean canJump(int[] nums) {
        cache=new int[nums.length];
        Arrays.fill(cache, -1);
        return cj(nums, 0);
    }
}
*/