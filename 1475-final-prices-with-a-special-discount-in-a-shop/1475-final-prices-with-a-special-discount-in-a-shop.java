class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int discountedPrices[]=new int[prices.length];
        stack.push(0);
        for(int i=prices.length-1; i>=0; i--)
        {
            while (stack.peek()>prices[i]) stack.pop();
            discountedPrices[i]=prices[i]-stack.peek();
            stack.push(prices[i]);
        }
        return discountedPrices;
    }
}