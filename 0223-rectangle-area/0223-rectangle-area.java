class Solution {
    int overlap(int a1, int a2, int b1, int b2)
    {
        int res = 0;
        
        if(a1 < b1)
        {
            int t = a1;
            a1 = b1;
            b1 = t;
        
            t = a2;
            a2 = b2;
            b2 = t;
        }
        
        if(b2 < a1) res = 0;
        else if(b2 < a2) res = b2 - a1;
        else res = a2 - a1;
        return res;
    }
    
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int dx = overlap(ax1, ax2, bx1, bx2), dy = overlap(ay1, ay2, by1, by2);
        return (Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2)) + (Math.abs(bx1 - bx2) * Math.abs(by1 - by2)) - (dx * dy);
    }
}