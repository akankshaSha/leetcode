class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack=new Stack<>();
        int nseAt[]=new int[heights.length];
        for(int i=heights.length-1; i>=0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nseAt[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        int pseAt[]=new int[heights.length];
        for(int i=0; i<heights.length; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            pseAt[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        int max=0;
        for(int i=0; i<heights.length; i++)
        {
            int base=0;
            if(nseAt[i]==-1 || pseAt[i]==-1)
            {
                if(nseAt[i]==-1 && pseAt[i]!=-1) base=heights.length-pseAt[i]-1;
                else if(pseAt[i]==-1 && nseAt[i]!=-1) base=nseAt[i];
                else base =heights.length;
            }
            else base=nseAt[i]-pseAt[i]-1;
            max=Math.max(max, base * heights[i]);
        }
        return max;
    }
}