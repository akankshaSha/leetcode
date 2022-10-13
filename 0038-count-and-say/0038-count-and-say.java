class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String t=countAndSay(n-1);
        String res="";
        int count=0, prev=-1, cur=0;
        for(int i=0; i<t.length(); i++)
        {
            cur=t.charAt(i)-'0';
            if(cur!=prev)
            {
                if(prev!=-1) res+=Integer.toString(count*10+prev);
                count=0;
                prev=cur;
            }
            count++;
        }
        res+=Integer.toString(count*10+prev);
        return res;
    }
}