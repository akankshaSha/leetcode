// disjont sets union find
class Solution {
    int find(int values[], int x)
    {
        return values[x]==x?x:find(values, values[x]);
    }
    
    public boolean equationsPossible(String[] equations) {
        int values[]=new int[26];
        for(int i=0; i<26; i++) values[i]=i;
        for(String equation: equations)
        {
            int a=equation.charAt(0)-'a';
            int b=equation.charAt(3)-'a';
            boolean equals=equation.charAt(1)=='='? true: false;
            if(equals)
            {
                int A=find(values, a);
                values[a]=A;
                int B=find(values, b);
                values[b]=B;
                if(A!=B)
                {
                    if(A<B) values[B]=A;
                    else values[A]=B;
                }
            }
        }
        
        for(String equation: equations)
        {
            int a=equation.charAt(0)-'a';
            int b=equation.charAt(3)-'a';
            boolean equals=equation.charAt(1)=='='? true: false;
            if(!equals)
            {
                if(find(values, a)==find(values, b)) return false;
            }
        }
        return true;
    }
}





// naive approach I am embarresed of, but hey! at least I got the problem right!
/*
class Solution {       
    public boolean equationsPossible(String[] equations) {
        int val[]=new int[26], distinct=1;
        for(String equation: equations)
        {
            int a=equation.charAt(0)-'a';
            int b=equation.charAt(3)-'a';
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
*/