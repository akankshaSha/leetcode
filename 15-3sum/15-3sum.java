class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++)
            {
                if(j-1!=i && nums[j]==nums[j-1]) continue;
                int target=(nums[i]+nums[j])*-1;
                int k=Arrays.binarySearch(nums, j+1, nums.length, target);
                if(k>=0)
                {
                    List<Integer> aux=new ArrayList<>();
                    aux.add(nums[i]);
                    aux.add(nums[j]);
                    aux.add(nums[k]);
                    res.add(aux);
                }
            }
        }
        return res;
    }
}