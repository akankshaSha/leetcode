class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands=new Stack<>();
        int op1=0, op2=0;
        for(String token: tokens)
        {
            switch(token)
            {
                case "/":
                    op1=operands.pop();
                    op2=operands.pop();
                    operands.push(op2/op1);
                    break;
                case "*":
                    op1=operands.pop();
                    op2=operands.pop();
                    operands.push(op1*op2);
                    break;
                case "+":
                    op1=operands.pop();
                    op2=operands.pop();
                    operands.push(op1+op2);
                    break;
                case "-":
                    op1=operands.pop();
                    op2=operands.pop();
                    operands.push(op2-op1);
                    break;
                default: operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}