class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[j]==nums[j-1] && j!=i+1) continue;
                int target=-(nums[i]+nums[j]);
                int k=Arrays.binarySearch(nums, j+1, nums.length, target);
                if(k>=0)
                {
                    List<Integer> triplet=Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(triplet);
                }
            }
        }
        return res;
    }
}