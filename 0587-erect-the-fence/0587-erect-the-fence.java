class Solution {
    int crossProduct(int a[], int b[], int c[])
    {
        return ((a[0] - b[0]) * (a[1] - c[1])) - ((a[0] - c[0]) * (a[1] - b[1]));
    }
    
    boolean farther(int a[], int b[], int c[])
    {
        double db = Math.sqrt ((b[0] - a[0])*(b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]));
        double dc = Math.sqrt ((c[0] - a[0])*(c[0] - a[0]) + (c[1] - a[1]) * (c[1] - a[1]));
        return db > dc;
    }
    
    public int[][] outerTrees(int[][] trees) {
        if(trees.length < 4) return trees;
        HashSet<Integer> fenceTrees = new HashSet<>();
        //1. start from the left most tree
        int s = 0;
        for(int i = 0; i<trees.length; i++)
            if(trees[i][0] < trees[s][0]) s = i;
            else if(trees[i][0] == trees[s][0] && trees[i][1] < trees[s][1]) s = i;
        
        //2. start march
        int t1 = s;
        while(true)
        {
            fenceTrees.add(t1);
            HashSet<Integer> coLinears = new HashSet<>();
            int t2 = t1==0 ? 1 : 0;
            for(int t3 = 0; t3 < trees.length; t3++)
            {
                if(t1 == t3 || t2 == t3) continue;
                int cp = crossProduct(trees[t1], trees[t2], trees[t3]);
                if(cp < 0)
                {
                    t2 = t3;
                    coLinears.clear();
                }
                else if (cp == 0)
                {
                    coLinears.add(t3);
                    coLinears.add(t2);
                    if(!farther(trees[t1], trees[t2], trees[t3])) t2 = t3;
                }
            }
            t1 = t2;
            fenceTrees.addAll(coLinears);
            if(t1 == s) break;
        }
        
        int res [][] = new int[fenceTrees.size()][2], k = 0;
        for(int index : fenceTrees) res[k++] = trees[index];
        return res;
    }
}