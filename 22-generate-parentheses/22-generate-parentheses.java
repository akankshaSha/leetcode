class Solution {
    static List<String> genP(int op, int cl, int n)
    {
        List<String> res=new ArrayList<>();        
        if(n==cl)
        {
            res.add("");
            return res;
        }
        if(op==n)
        {
            List<String> close=genP(op, cl+1, n);
            for(int i=0; i<close.size(); i++) close.set(i, ")"+close.get(i));
            return close;
        }
        if(op==cl)
        {
            List<String> open=genP(op+1, cl, n);
            for(int i=0; i<open.size(); i++) open.set(i, "("+open.get(i));
            return open;
        }
        List<String> open=genP(op+1, cl, n);
        for(int i=0; i<open.size(); i++) open.set(i, "("+open.get(i));
        List<String> close=genP(op, cl+1, n);
        for(int i=0; i<close.size(); i++) close.set(i, ")"+close.get(i));
        res.addAll(open);
        res.addAll(close);  
        return res;
    }
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<String>();
        return genP(0, 0, n);
    }
}