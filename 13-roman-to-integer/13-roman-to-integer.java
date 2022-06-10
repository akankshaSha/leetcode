class Solution {
    public int romanToInt(String s) 
    {
        if(s.length()==0) return 0;
        
        int n=0;
        String R="IVXLCDM";
        int r[]={1,5,10,50,100,500,1000};
        
        if(s.length()==1) return r[R.indexOf(s.charAt(0))];
        
        for(int i=0; i<s.length()-1; i++)
        {
            if(R.indexOf(s.charAt(i)) < R.indexOf(s.charAt(i+1)))
                n+=r[R.indexOf(s.charAt(i+1))]-r[R.indexOf(s.charAt(i++))];
            else
                n+=r[R.indexOf(s.charAt(i))];
        }
        
        if(R.indexOf(s.charAt(s.length()-1))<=R.indexOf(s.charAt(s.length()-2)))
            n+=r[R.indexOf(s.charAt(s.length()-1))];
        
        return n;
    }
}