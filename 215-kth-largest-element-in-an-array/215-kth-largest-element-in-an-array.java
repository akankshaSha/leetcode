class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((Integer n1, Integer n2)->n1-n2);
        for(int num: nums) heap.add(num);
        int res=0;
        while(heap.size()>=k) res=heap.poll();
        return res;
    }
}