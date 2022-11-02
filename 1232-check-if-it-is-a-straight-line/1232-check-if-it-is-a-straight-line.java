class Solution {
    public boolean checkStraightLine(int[][] cordinates) {
        double m = (double)(cordinates[0][1] - cordinates[1][1]) / (cordinates[0][0] - cordinates[1][0]) ;
        for(int i =2; i<cordinates.length; i++)
        {
            double dm = (double)(cordinates[0][1] - cordinates[i][1]) / (cordinates[0][0] - cordinates[i][0]) ;
            if(dm == Math.abs(Double.POSITIVE_INFINITY) && dm == Math.abs(Double.POSITIVE_INFINITY)) continue;
            else if(dm != m) return false;
        }
        return true;
    }
}