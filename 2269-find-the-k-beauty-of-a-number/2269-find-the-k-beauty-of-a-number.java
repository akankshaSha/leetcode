class Solution {
    public int divisorSubstrings(int num, int k) {
        int kBeauty=0;
        String n = Integer.toString(num);
        int start=0, end=0;
        for(end=k; end<=n.length(); end++)
        {
            int divisor=Integer.parseInt(n.substring(start, end));
            start++;
            if(divisor==0) continue;
            if(num%divisor==0) kBeauty++;
        }
        return kBeauty;
    }
}