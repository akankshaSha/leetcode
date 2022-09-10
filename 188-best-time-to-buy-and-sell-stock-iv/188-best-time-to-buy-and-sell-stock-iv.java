class Solution {
    int cache[][][];
    public int trade(int prices[], int buyIndex, int k, int index)
    {
        if(index==prices.length || (k==0 && buyIndex==-1)) return 0;
        if(cache[buyIndex+1][k][index]>-1) return cache[buyIndex+1][k][index];
        int buy=Integer.MIN_VALUE, sell=Integer.MIN_VALUE, leave=0;
        if(buyIndex==-1) buy=trade(prices, index, k-1, index+1);
        else sell=trade(prices, -1, k, index+1)+prices[index]-prices[buyIndex];
        leave=trade(prices, buyIndex, k, index+1);
        int m=Math.max(buy, sell);
        cache[buyIndex+1][k][index]=Math.max(m, leave);
        return cache[buyIndex+1][k][index];
    }
    public int maxProfit(int k, int[] prices) {
        cache=new int[prices.length+1][k+1][prices.length];
        for(int m[][]: cache)
            for(int a[]: m)
                Arrays.fill(a, -1);
        return trade(prices, -1, k, 0);        
    }
}

//brute force:
// time complexity: 2ⁿ
// space complexity: 2ⁿ
/*
class Solution {
    public int trade(int prices[], int buyIndex, int k, int index)
    {
        if(index==prices.length || (k==0 && buyIndex==-1)) return 0;
        int buy=Integer.MIN_VALUE, sell=Integer.MIN_VALUE, leave=0;
        if(buyIndex==-1) buy=trade(prices, index, k-1, index+1);
        else sell=trade(prices, -1, k, index+1)+prices[index]-prices[buyIndex];
        leave=trade(prices, buyIndex, k, index+1);
        int m=Math.max(buy, sell);
        return Math.max(m, leave);
    }
    public int maxProfit(int k, int[] prices) {
        return trade(prices, -1, k, 0);
    }
}
*/