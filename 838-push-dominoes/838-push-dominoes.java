class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder res=new StringBuilder();
        int right[]=new int[dominoes.length()], left[]=new int [dominoes.length()];
        left[left.length-1]= dominoes.charAt(left.length-1)=='L'?0:Integer.MAX_VALUE;
        for(int i=left.length-2; i>-1; i--)
        {
            char dominoe=dominoes.charAt(i);
            if(dominoe=='R') left[i]=Integer.MAX_VALUE;
            else if(dominoe=='L') left[i]=0;
            else left[i]=left[i+1]==Integer.MAX_VALUE?Integer.MAX_VALUE:left[i+1]+1;
        }
        right[0]=dominoes.charAt(0)=='R'?0:Integer.MAX_VALUE;
        for(int i=1; i<right.length; i++)
        {
            char dominoe=dominoes.charAt(i);
            if(dominoe=='L') right[i]=Integer.MAX_VALUE;
            else if(dominoe=='R') right[i]=0;
            else right[i]=right[i-1]==Integer.MAX_VALUE?Integer.MAX_VALUE:right[i-1]+1;
        }
        
        
        for(int i=0; i<dominoes.length(); i++)
        {
            char dominoe=dominoes.charAt(i);
            if(dominoes.charAt(i)=='.')
            {
                if(left[i]<right[i]) res.append("L");
                else if(right[i]<left[i]) res.append("R");
                else res.append(".");
            }
            else res.append(dominoe);
        }
        return res.toString();
    }
}