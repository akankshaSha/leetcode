class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        Stack<Integer> open=new Stack<>();
        Stack<Integer> close=new Stack<>();
        Stack<String> parentheses=new Stack<>();
        open.push(0);
        close.push(0);
        parentheses.push("");
        while(!parentheses.isEmpty())
        {
            int op=open.pop();
            int cl=close.pop();
            String p=parentheses.pop();
            if(cl==n) res.add(p);
            else if(op==n)
            {
                open.push(op);
                close.push(cl+1);
                parentheses.push(p+")");
            }
            else if(op==cl)
            {
                open.push(op+1);
                close.push(cl);
                parentheses.push(p+"(");
            }
            else
            {
                open.push(op);
                close.push(cl+1);
                parentheses.push(p+")");
                open.push(op+1);
                close.push(cl);
                parentheses.push(p+"(");
            }
        }
        
        return res;
    }
}