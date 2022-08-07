class Solution {
    public int countVowelPermutation(int n) {
        long M[][]=new long[6][n+1];
        int mod=1000000007;
        for(int i=0; i<M.length; i++) M[i][0]=1;
        M[0][0]=0;
        
        for(int j=1; j<M[0].length; j++)
        {
            long sumNull=0, sumI=0;
            for(int i=1; i<6; i++)
            {
                sumNull+=M[i][j-1];
                if(i==3) continue;
                sumI+=M[i][j-1];
            }
            M[0][j]=sumNull%mod;
            M[1][j]= M[2][j-1];
            M[2][j]= M[1][j-1]+M[3][j-1];
            M[3][j]= sumI%mod;
            M[4][j]= M[3][j-1]+M[5][j-1];
            M[5][j]= M[1][j-1];
        }
        return (int)(M[0][n]%mod);
    }
}





//recursive solution
/*
class Solution {
    int fillString(char prev, char[]vowels, int n)
    {
        if(n==0) return 1;
        
        if(prev=='a')
            return fillString('e', vowels, n-1);
        if(prev=='e')
            return fillString('a', vowels, n-1) + fillString('i', vowels, n-1);
         if(prev=='o')
            return fillString('i', vowels, n-1) + fillString('u', vowels, n-1);
        if(prev=='u')
            return fillString('a', vowels, n-1);
        int res=0;
        for(char vowel: vowels)
        {
            if(prev=='i' && vowel=='i') continue;
            res+=fillString(vowel, vowels, n-1);
        }
        return res;
    }
    public int countVowelPermutation(int n) {
        char vowels[]={'a', 'e', 'i', 'o', 'u'};
        int count=fillString('\u0000', vowels, n);
        return count;
    }
}
*/