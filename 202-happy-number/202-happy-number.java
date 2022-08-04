class Solution {
    public int sod(int n)
    {
        int sum=0;
        while(n>0)
        {
            int i=n%10;
            sum+=i*i;
            n/=10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int k=n;
        HashSet<Integer> set=new HashSet<>();
        while(true)
        {
            k=sod(k);
            if(k==1) return true;
            if(set.contains(k)) return false;
            set.add(k);
        }
    }
}