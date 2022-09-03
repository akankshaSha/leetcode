class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dec=new ArrayDeque<>();
        int res[]=new int[nums.length-k+1], index=0;
        for(int i=0; i<nums.length; i++)
        {
            if(!dec.isEmpty() && dec.getFirst()<i-k+1) dec.poll();
            while(dec.size()>k || (!dec.isEmpty() && nums[dec.getLast()]<nums[i]))
                dec.pollLast();
            dec.add(i);
            if(i>=k-1) res[index++]=nums[dec.peek()];
        }
        return res;
    }
}