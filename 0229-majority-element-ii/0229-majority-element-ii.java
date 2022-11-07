class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> f = new HashMap<>();
        for(int num : nums) f.put(num, f.getOrDefault(num, 0) +1);
        
        int target = nums.length / 3;
        for(int num : f.keySet()) if(f.get(num) > target) res.add(num);
        return res;
    }
}