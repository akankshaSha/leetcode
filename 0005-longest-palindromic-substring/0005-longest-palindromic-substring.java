class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int maxLen=0;
        String res="";
        for(int mid=0; mid<s.length(); mid++)
        {
            int len=1;
            int left=mid-1, right=mid+1;
            while(-1<left && right<s.length())
            {
                if(s.charAt(left)!=s.charAt(right)) break;
                len+=2;
                left--;
                right++;
            }
            if(len>maxLen)
            {
                maxLen=len;
                res=s.substring(left+1, right);
            }
        }
        
        for(int l=0; l<s.length()-1; l++)
        {
            int left=l, right=l+1, len=0;
            while(-1<left && right<s.length())
            {
                if(s.charAt(left)!=s.charAt(right)) break;
                len+=2;
                left--;
                right++;
            }
            if(len>maxLen)
            {
                System.out.println(len);
                maxLen=len;
                res=s.substring(left+1, right);
            }
        }
        return res;
    }
}