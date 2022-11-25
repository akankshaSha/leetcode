class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0, mod = 1000000007;
        Stack <Integer> elements = new Stack<>(); //monotonically increasing elemnts
        Stack <Integer> polls = new Stack<>(); // number of elements popped by element
        Stack <Long> sums = new Stack<>(); // recurring sum of element * poll
        
        for(int element : arr)
        {
            int poll = 1;
            while(!elements.isEmpty())
            {
                if(elements.peek() < element) break;
                elements.pop();
                sums.pop();
                poll += polls.pop();
            }
            elements.push(element);
            polls.push(poll);
            long c = (element * poll) % mod;
            if(sums.isEmpty()) sums.push(c);
            else sums.push(sums.peek() % mod + c);
            res %= mod;
            res += sums.peek();
        }
        return (int) res;
    }
}