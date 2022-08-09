class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[]=new int[temperatures.length];
        Stack<Integer> index=new Stack<>();
        for(int i=0; i<temperatures.length; i++)
        {
            while(!index.empty() && temperatures[index.peek()] < temperatures[i])
            {
                int j=index.pop();
                res[j]=i-j;
            }
            index.push(i);
        }
        return res;
    }
}