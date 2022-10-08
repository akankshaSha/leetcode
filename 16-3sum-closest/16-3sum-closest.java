class Solution {
    
    int search(int nums[], int start, int target)
    {
        if(start==nums.length-1) return nums[start];
        int left=start, right=nums.length-1, mid=0;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(target<nums[mid])right=mid-1;
            else if(target>nums[mid])left=mid+1;
            else break;
        }
        
        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, c=Integer.MAX_VALUE;
        if(mid>start) a=Math.abs(target-nums[mid-1]);
        b=Math.abs(target-nums[mid]);
        if(mid<nums.length-1) c=Math.abs(target-nums[mid+1]);
        if(a<b && a<c) return nums[mid-1];
        if(c<a && c<b) return nums[mid+1];
        return nums[mid];
    }
    
    public int threeSumClosest(int[] nums, int target) {
        int res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++)
        {
            for(int j=i+1; j<nums.length-1; j++)
            {
                int t=target-nums[i]-nums[j];
                int ct=search(nums, j+1, t);
                int closeTarget=nums[i]+nums[j]+ct;
                if(Math.abs(target-res) > Math.abs(target-closeTarget)) res=closeTarget;
            }
        }
        return res;
    }
}