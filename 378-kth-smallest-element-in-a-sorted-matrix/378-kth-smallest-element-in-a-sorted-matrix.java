class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int row[]: matrix)
        {
            for(int e: row)
            {
                minHeap.add(e);
                if(minHeap.size()>k) minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}