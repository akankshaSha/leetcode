class Solution {
    int detonate(int[][] bombs, boolean detonated[], int node)
    {
        if(detonated[node]) return 0;
        detonated[node]=true;
        int score=1;
        for(int i=0; i<bombs.length; i++)
        {
            if(i==node) continue;
            long dx=bombs[node][0]-bombs[i][0];
            long dy=bombs[node][1]-bombs[i][1];
            double d=Math.sqrt(dx*dx + dy*dy);
            if(d<=bombs[node][2]) score+= detonate(bombs, detonated, i);
        }
        return score;
    }
    
    
    public int maximumDetonation(int[][] bombs) {
        int res=0;
        
        for(int i=0; i<bombs.length; i++)
        {
            boolean detonated[]=new boolean[bombs.length];
            res=Math.max(res, detonate(bombs, detonated, i));
        }
        return res;
    }
}