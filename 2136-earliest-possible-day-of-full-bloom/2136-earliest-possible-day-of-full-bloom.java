class Plant
{
    int pt, gt;
    Plant(int p, int g)
    {
        pt=p;
        gt=g;
    }
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<Plant> plants=new PriorityQueue<>((a, b)->Integer.compare(b.gt, a.gt));
        for(int i=0; i<plantTime.length; i++) plants.offer(new Plant(plantTime[i], growTime[i]));
        int time=0, res=0;
        while(!plants.isEmpty())
        {
            Plant plant=plants.poll();
            time+=plant.pt;
            res=Math.max(res, time+plant.gt);
        }
        return res;
    }
}