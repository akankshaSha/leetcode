class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0, length=0;
        HashMap<Integer, Integer> sumIndex=new HashMap<>();
        sumIndex.put(0, -1);
        for(int i=0; i<nums.length; i++)
        {
            sum=nums[i]==1?sum+1:sum-1;
            if(sumIndex.containsKey(sum))
                length=Math.max(length, i-sumIndex.get(sum));
            else
                sumIndex.put(sum, i);
        }
        return length;
    }
}