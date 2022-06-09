class Solution {
    public int myAtoi(String s) {
        StringBuilder number=new StringBuilder("");
        boolean digitsFound=false, signFound=false, wtSpaceEnd=false;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ' && !wtSpaceEnd) continue;
            else wtSpaceEnd=true;
            if(!signFound && !digitsFound && (s.charAt(i)=='-' || s.charAt(i)=='+') && i!=s.length()-1)
            {
                number.append(s.charAt(i));
                signFound=true;
                continue;
            }
            if(s.charAt(i)<'0' || s.charAt(i)>'9') break;
            number.append(s.charAt(i));
            digitsFound=true;
        }
        
        int res=0;
        boolean n=false;
        for(int i=0; i<number.length(); i++)
        {
            if(number.charAt(i)=='+') continue;
            if(number.charAt(i)=='-')
            {
                n=true;
                continue;
            }
            int cur=(int)(number.charAt(i)-'0');
            if(res>Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
            if(res==Integer.MAX_VALUE/10 && cur>7) return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE/10) return Integer.MIN_VALUE;
            if(res==Integer.MIN_VALUE/10 && cur>8) return Integer.MIN_VALUE;
            if(n)
                res=res*10-cur;
            else
                res=res*10+cur;
        }
        return res;
    }
}