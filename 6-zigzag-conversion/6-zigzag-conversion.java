class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()==1) return s;
        int size=2*numRows-2;
        String strs[]=new String[numRows];
        for(int i=0; i<strs.length; i++) strs[i]="";
        int map[]=new int[size];
        for(int i=0; i<numRows; i++) map[i]=i;
        for(int i=numRows; i<map.length; i++) map[i]=size-i;
        
        for(int i=0; i<s.length(); i++)
        {
            int rindex=i%size;
            strs[map[rindex]]+=s.charAt(i);
        }
        String res="";
        for(int i=0; i<numRows; i++)
        {
            res+=strs[i];
        }
        return res;
    }
}