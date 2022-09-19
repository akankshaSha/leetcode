class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a, b)->Integer.compare(b, a));
        for(int stone: stones) minHeap.offer(stone);
        while(minHeap.size()>1)
        {
            int y=minHeap.poll();
            int x=minHeap.poll();
            if(x!=y) minHeap.offer(y-x);
        }
        if(minHeap.isEmpty()) return 0;
        return minHeap.poll();
    }
}