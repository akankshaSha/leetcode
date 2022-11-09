class StockSpan
{
    int price;
    int days;
    StockSpan(int price, int days)
    {
        this.price = price;
        this.days = days;
    }
}

class StockSpanner {
    Stack<StockSpan> stockPrices; //monotonucally decreasing
    public StockSpanner() {
        stockPrices = new Stack<>();
    }
    
    public int next(int price) {
        int dayCount = 1;
        while(!stockPrices.empty())
        {
            if(stockPrices.peek().price > price) break;
            StockSpan stockSpan = stockPrices.pop();
            dayCount += stockSpan.days;
        }
        stockPrices.push(new StockSpan(price, dayCount));
        return stockPrices.peek().days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */