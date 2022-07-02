class Solution {
    
    static long maxf(int arr[])
    {
        long max=Integer.MIN_VALUE;
        for(int e: arr) max=Math.max(e, max);
        return max;
    }
    
    static int[] getDistances(int cuts[], int bound)
    {
        Arrays.sort(cuts);
        int dist[]=new int[cuts.length+1], t=0;
        
        for(int i=0; i<cuts.length; i++)
        {
            dist[i]=cuts[i]-t;
            t=cuts[i];
        }
        dist[dist.length-1] = bound - cuts[cuts.length-1];
        return dist;
    }
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int t=0, hcd[]=getDistances(horizontalCuts, h), vcd[]=getDistances(verticalCuts, w);
        long a=maxf(hcd);
        long b=maxf(vcd);
        return (int)(a*b%1000000007);
    }
}