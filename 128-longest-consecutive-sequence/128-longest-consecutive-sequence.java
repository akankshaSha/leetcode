class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> h=new HashSet<>();
        for(int e: nums) h.add(e);
        int max=0;
        for(int e: h)
        {
            if(!h.contains(e-1))
            {
                int count=1;
                while(h.contains(e+1))
                {
                    count++;
                    e++;
                }
                max=Math.max(max, count);
            }
        }
        return max;
    }
}