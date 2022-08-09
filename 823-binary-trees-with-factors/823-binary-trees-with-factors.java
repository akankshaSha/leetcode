class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Long> rootNum=new HashMap<>();
        
        for(int i=0; i<arr.length; i++)
        {
            long c=0;
            for(int j=0; j<i; j++)
            {
                if(arr[i]%arr[j]!=0) continue;
                int t=arr[i]/arr[j];
                long a=rootNum.get(arr[j]);
                long b=rootNum.getOrDefault(t, 0L);
                c+=a*b;
            }
            rootNum.put(arr[i], c+1);
        }
        //System.out.println(rootNum);
        long sum=0;
        for(long num: rootNum.values()) sum+=num;
        return (int) (sum%1000000007);
    }
}