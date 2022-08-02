class Solution {
    public int maxArea(int[] heights) {
        int p=0, q=heights.length-1, max=0;
        while(p<q)
        {
            int area=Math.min(heights[p], heights[q]) * (q-p);
            max=Math.max(max, area);
            if(heights[p]<heights[q]) p++;
            else q--;
        }
        return max;
    }
}