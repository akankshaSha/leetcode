class Solution {
    int distribute(int [] cookies, int index, int children[])
    {
        if(index == cookies.length)
        {
            int max = 0;
            for(int child : children) max = Math.max(max, child);
            return max;
        }
        
        int res=Integer.MAX_VALUE;
        for(int i =0; i<children.length; i++)
        {
            children[i] += cookies[index];
            res = Math.min(res, distribute(cookies, index+1, children));
            children[i] -= cookies[index];
        }
        return res;
    }
    public int distributeCookies(int[] cookies, int k) {
        return distribute(cookies, 0, new int[k]);        
    }
}