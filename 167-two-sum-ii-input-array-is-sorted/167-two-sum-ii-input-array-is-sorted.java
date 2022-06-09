class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a[]=new int[2];
        for(int i=0; i<numbers.length; i++)
        {
            int s=target-numbers[i];
            int j=Arrays.binarySearch(numbers, s);
            if(j>=0 && i!=j)
            {
                a[0]=Math.min(i,j)+1;
                a[1]=Math.max(i,j)+1;
                break;
            }
        }
        return a;
    }
}