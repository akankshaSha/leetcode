class Solution {
    public int minCost(String colors, int[] neededTime) {
        List<Pair<Character, Integer>> rope=new ArrayList<>();
        for(int i=0; i<colors.length(); i++) rope.add(new Pair(colors.charAt(i), neededTime[i]));
        
        List<Pair<Character, Integer>> colorfulRope=new ArrayList<>();
        int time=0;
        for(Pair<Character, Integer>baloon: rope)
        {
            if(colorfulRope.isEmpty()) colorfulRope.add(baloon);
            else
            {
                Pair<Character, Integer> last=colorfulRope.get(colorfulRope.size()-1);
                if(last.getKey()==baloon.getKey())
                {
                    if(last.getValue()>baloon.getValue()) time+=baloon.getValue();
                    else
                    {
                        colorfulRope.set(colorfulRope.size()-1, baloon);
                        time+=last.getValue();
                    }
                }
                else colorfulRope.add(baloon);
            }
        }
        return time;
    }
}