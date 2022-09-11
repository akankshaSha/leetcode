class Engineer
{
    int speed;
    int efficiency;
    Engineer(int speed, int efficiency)
    {
        this.speed=speed;
        this.efficiency=efficiency;
    }
}

class Solution {    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer engineers[]=new Engineer[n];
        for(int i=0; i<n; i++) engineers[i]=new Engineer(speed[i], efficiency[i]);
        Arrays.sort(engineers, (Engineer a, Engineer b)->Integer.compare(b.efficiency, a.efficiency));
        
        PriorityQueue<Engineer> maxHeap=new PriorityQueue<Engineer>((Engineer a, Engineer b)->(a.speed== b.speed)? Integer.compare(a.efficiency, b.efficiency):Integer.compare(a.speed, b.speed));
        
        long sumSpeed=0, res=Long.MIN_VALUE;
        for(Engineer eng: engineers)
        {
            if(maxHeap.size()>=k) sumSpeed-=maxHeap.poll().speed;
            maxHeap.offer(eng);
            sumSpeed+=eng.speed;
            res=Math.max(res, sumSpeed*eng.efficiency);
        }
        return (int) (res%1000000007);
    }
}