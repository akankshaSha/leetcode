class KthLargest {
    PriorityQueue <Integer> maxHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.maxHeap=new PriorityQueue<>((a, b)->Integer.compare(a,b));
        this.k=k;
        for(int num: nums) add(num);
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        if(maxHeap.size()>k) maxHeap.poll();
        return maxHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */