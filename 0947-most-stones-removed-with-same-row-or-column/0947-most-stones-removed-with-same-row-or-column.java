class Solution {
    
    int find(int set[], int e)
    {
        int t = e;
        while(set[t] != t) t=set[t];
        set[e] = t;
        return t;
    }
    
    public int removeStones(int[][] stones) {
        //1. Make Set
        int set[] = new int[stones.length];
        for(int i = 0; i<stones.length; i++) set[i] = i;
        
        //2. union-find
        for(int i = 0; i<stones.length; i++)
        {
            for(int j = i+1; j<stones.length; j++)
            {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    int I = find(set, i);
                    int J = find(set, j);
                    if(I>J) set[I] = set[J];
                    else if(J>I) set[J] = set[I];
                }
            }
        }
        
        for(int i = 0; i<stones.length; i++) set[i] = find(set, i);
        
        //3. count number of unique elements in set
        HashSet<Integer> unique = new HashSet<>();
        for(int e:set) unique.add(e);
        
        //4. return deletable elements
        return set.length - unique.size();
    }
}