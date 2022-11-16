/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int p=0, q=0, r=n;
        while(p<=r)
        {
            q=p+(r-p)/2;
            if(guess(q)<0) r=q-1;
            else if(guess(q)>0) p=q+1;
            else break;
        }
        return q;
    }
}