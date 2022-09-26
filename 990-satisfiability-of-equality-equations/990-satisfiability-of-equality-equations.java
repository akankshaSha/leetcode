class Solution {       
    public boolean equationsPossible(String[] equations) {
        int val[]=new int[26], distinct=1;
        for(String equation: equations)
        {
            char a=equation.charAt(0);
            char b=equation.charAt(3);
            boolean equals=equation.charAt(1)=='='? true: false;
            if(equals)
            {
                if(val[a-'a']!=0 && val[b-'a']!=0)
                {
                    int vala=val[a-'a'];
                    int valb=val[b-'a'];
                    for(int i=0;i<val.length; i++)
                    {
                        if(val[i]==vala || val[i]==valb) val[i]=distinct;
                    }
                    distinct++;
                }
                else if(val[a-'a']==0 && val[b-'a']==0) val[a-'a']=val[b-'a']=distinct++;
                else val[a-'a']=val[b-'a']=val[a-'a']|val[b-'a'];
            }
        }
        for(String equation: equations)
        {
            char a=equation.charAt(0);
            char b=equation.charAt(3);
            boolean equals=equation.charAt(1)=='='? true: false;
            if(val[a-'a']==0 && val[b-'a']==0 && b!=a) continue;
            if(!equals && val[a-'a']==val[b-'a']) return false;
        }
        return true;
    }
}