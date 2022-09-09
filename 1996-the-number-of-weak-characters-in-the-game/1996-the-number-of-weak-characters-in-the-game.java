class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Comparator c=new Comparator<int[]>()
        {
            public int compare(int a[], int b[])
            {
                if(a[0]>b[0]) return -1;
                if(a[0]<b[0]) return 1;
                else
                {
                    if(a[1]>b[1]) return 1;
                    if(a[1]<b[1]) return -1;
                }
                return 0;
            }
        };
        Arrays.sort(properties, c);
        int maxDefence[]=new int[properties.length];
        
        for(int i=1; i<properties.length; i++)
            maxDefence[i]=properties[maxDefence[i-1]][1]>properties[i][1]?maxDefence[i-1]:i;
        
        int count=0;
        for(int i=0; i<properties.length; i++)
        {
            if(properties[i][1]<properties[maxDefence[i]][1] && properties[i][0]<properties[maxDefence[i]][0])
            count++;
        }
        return count;
    }
}