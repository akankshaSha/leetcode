class Cordinate
{
    int x;
    int y;
    double dist;
    Cordinate(int x, int y)
    {
        this.x=x;
        this.y=y;
        this.dist=Math.sqrt(x*x+y*y);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Cordinate> minHeap=new PriorityQueue<>(new Comparator<Cordinate>()
        {
            public int compare(Cordinate p, Cordinate q)
            {
                if(p.dist>q.dist) return -1;
                if(p.dist<q.dist) return 1;
                return 0;
                
            }
        });
        
        for(int point[]: points)
        {
            minHeap.add(new Cordinate(point[0], point[1]));
            if(minHeap.size()>k) minHeap.poll();
        }
        
        int i=0;
        int res[][]=new int[k][2];
        while(minHeap.size()>0)
        {
            Cordinate p=minHeap.poll();
            res[i][0]=p.x;
            res[i][1]=p.y;
            i++;
        }
        return res;
    }
}