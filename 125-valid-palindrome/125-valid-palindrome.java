class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0; i<s.length(); i++)
        {
            char c=s.charAt(i);
           if(c>='A' && c<='Z') str+=(char)(c+' ');
           if(c>='a' && c<='z') str+=c; 
            if(c>='0' && c<='9') str+=c; 
        }
        
        int p=0, q=str.length()-1;
        while(p<q)
        {
            if(str.charAt(p)!=str.charAt(q)) return false;
            p++;
            q--;
        }
        return true;
    }
}