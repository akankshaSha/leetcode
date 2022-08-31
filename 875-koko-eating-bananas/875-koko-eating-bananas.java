class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        int q=Integer.MIN_VALUE, p=1, r=0;
        for(int pile:piles) q=Math.max(q, pile);
        
        while(p<q)
        {
            r=(p+q)/2;
            int time=0;
            for(int pile: piles) time+=Math.ceil((double)(pile)/r);
            if(time<=h) q=r;
            else p=r+1;
        }
        return q;
    }
}
//brute force:
/*
class Solution {
    boolean consumable(int piles[], int k, int h)
    {
        int i=0;
        for(int time=0; time<=h; time++)
        {
            if(piles[i]<=0) i++;
            if(i==piles.length) return true;
            piles[i]-=k;
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int k=0;
        do k++; while(!consumable(Arrays.copyOf(piles, piles.length), k, h));
        return k;
    }
}
*/