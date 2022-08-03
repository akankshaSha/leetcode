class Solution {
    public int maxProfit(int[] prices) {
        int buy=0, sell=0, profit=0;
        
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i]>prices[buy])
            {
                if(prices[sell]<prices[i]) sell=i;
                continue;
            }
            profit=Math.max(profit, prices[sell]-prices[buy]);
            buy=i;
            sell=i;
        }
        profit=Math.max(profit, prices[sell]-prices[buy]);
        return profit;
    }
}