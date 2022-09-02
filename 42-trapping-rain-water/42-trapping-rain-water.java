class Solution {
    public int trap(int[] height) {
        int left=0, right=height.length-1, water=0, maxLeft=height[left], maxRight=height[right];
        while(left<=right)
        {
            if(maxLeft<maxRight)
            {
                int h=maxLeft-height[left];
                if(h>0) water+=h;
                maxLeft=Math.max(maxLeft, height[left]);
                left++;
            }
            else
            {
                int h=maxRight-height[right];
                if(h>0) water+=h;
                maxRight=Math.max(maxRight, height[right]);
                right--;
            }
        }
        return water;
    }
}

//O(n) space solution:
/*
class Solution {
    public int trap(int[] height) {
        int maxLeft[]=new int[height.length], maxRight[]=new int[height.length], water=0;
        maxLeft[0]=height[0];
        for(int i=1; i<height.length; i++) maxLeft[i]=Math.max(maxLeft[i-1], height[i]);
        maxRight[maxRight.length-1]=height[height.length-1];
        for(int i=maxRight.length-2; i>=0; i--) maxRight[i]=Math.max(maxRight[i+1], height[i]);
        
        for(int i=0; i<height.length; i++)
        {
            int h=Math.min(maxRight[i], maxLeft[i])-height[i];
            if(h>0) water+=h;
        }
        return water;
    }
}
*/