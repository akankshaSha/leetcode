class Solution {
    static List<Integer> fill(int num[], int index, int k)
    {
        List<Integer> res=new ArrayList<>();
        if(index==num.length)
        {
            int number=0;
            for(int d: num) number=number*10 + d;
            res.add(number);
            return res;
        }
        if(num[index-1]+k<10) 
        {
            num[index]=num[index-1]+k;
            res.addAll(fill(num, index+1, k));
        }
        if(num[index-1]-k>-1 && k!=0) 
        {
            num[index]=num[index-1]-k;
            res.addAll(fill(num, index+1, k));
        }
        return res;
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        int num[]=new int[n];
        List<Integer> res=new ArrayList<>();
        for(int i=1; i<=9; i++)
        {
            num[0]=i;
            res.addAll(fill(num, 1, k));
        }
        int arr[]=new int[res.size()];
        int i=0;
        for(int r: res) arr[i++]=r;
        return arr;
    }
}