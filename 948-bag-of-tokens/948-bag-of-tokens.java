class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0;
        int left=0, right=tokens.length-1;
        while(left<right)
        {
            if(power>tokens[left])
            {
                power-=tokens[left++];
                score++;
            }
            else if(score>0)
            {
                power+=tokens[right--];
                score--;
            }
            else break;
        }
        if(left==right && power>=tokens[left]) score++;
        return score;
    }
}