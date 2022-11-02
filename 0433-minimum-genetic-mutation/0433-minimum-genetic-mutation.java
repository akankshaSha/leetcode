class Solution {
    int mutateDistance(String a , String b)
    {
        int res=0;
        for(int i=0; i<a.length(); i++) if(a.charAt(i)!=b.charAt(i)) res++;
        return res;
    }
    
    int mutate(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        int res=Integer.MAX_VALUE;
        for(int i=0; i<bank.length; i++)
        {
            if(mutateDistance(start, bank[i])==1)
            {
                String d=bank[i];
                bank[i]="XXXXXXXX";
                res=Math.min(res, mutate(d, end, bank));
                bank[i]=d;
            }
        }
        if(res==Integer.MAX_VALUE) return res;
        return res+1;
    }
    
    public int minMutation(String start, String end, String[] bank) {
        int res=mutate(start, end, bank);
        if(res==Integer.MAX_VALUE) return -1;
        return res;
    }
}