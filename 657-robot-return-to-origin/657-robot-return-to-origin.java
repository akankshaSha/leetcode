class Solution {
    public boolean judgeCircle(String moves) {
        int x=0, y=0;
        for(int i=0; i<moves.length(); i++)
        {
            if(moves.charAt(i)=='U') y+=1;
            if(moves.charAt(i)=='D') y-=1;
            if(moves.charAt(i)=='R') x+=1;
            if(moves.charAt(i)=='L') x-=1;
        }
        return x==0 && y==0;
    }
}